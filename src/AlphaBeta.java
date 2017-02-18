import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class AlphaBeta {
	Timer timer;
	private final int TURNTIME = 1800;
	private boolean turnends = false;
	private final int depth = 2;
	
	private ActionListener listener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			turnends = true;
		}
	};

	private double eval(Board board, String move, int player) {
		int[] states = board.checkState(player, move, false);
		return states[2] * 1 + states[1] * 0.1 + states[0] * 0.05;
	}

	public String alphabetasearch(Board board, char us) {
		//create timeListener to update TURNENDS value when time runs out
		timer = new Timer(TURNTIME, listener);
		
		//run alphabeta search
		Object[] move = {minimaxValue(board, Double.NEGATIVE_INFINITY, 
				Double.POSITIVE_INFINITY, depth, 1)};
		//return move returned by alpha beta
		return (String)move[1];
		
//		int value = minimaxValue(board, -100, 100, depth, 1);
//		//return move returned by alpha beta
//		return value;
	}

	private Object[] minimaxValue(Board board, double alpha, double beta, 
									int depth, int player){
		
		//generate moves
		ArrayList<String> moveList = board.getMoves(); 
		
//		if(board.child.size() == 0) return board.value;
//		ArrayList<Board> child = board.child;		
		
		double bestValue = Double.NEGATIVE_INFINITY;
//		int bestValue = -100;
		String position = "";
		
		
		for (int i = 0; i < moveList.size(); i++) {
			Board newboard = new Board(board);
			board.setMove(moveList.get(i), player);
			
			//check cutoff tests
			//return current move and heuristic if TRUE
			if (cutoff_test(board, depth, moveList.get(i), player)) {
				Object[] move = {eval(board, moveList.get(i), player), moveList.get(i)};
				return move;
			}
			
			Object[] v = minimaxValue(newboard, -beta, -alpha, depth-1, -player);
			
//			int v = -minimaxValue(child.get(i), -beta, -alpha, depth, player);
			
			//bestValue := max(bestValue, v)
			if(bestValue < -(Double)v[0]){
				bestValue = -(Double)v[0];
				//set new best move
				position = moveList.get(i);
			}
			
//			if(bestValue < v){
//				bestValue = v;
//			}
			
			//update alpha
			alpha = Math.max(alpha,-(Double)v[0]);
			
			//check pruning condition
			if(alpha >= beta){
				Object[] move = {bestValue, position};
				return move;
			}
			
//			if(alpha>=beta) return bestValue;
		}
		//return best move
		Object[] move = {bestValue, position};
		return move;
	}

	private boolean cutoff_test(Board board, int depth, String move, int player) {
		if (depth == 0) {return true;}
		if (turnends) {return true;}
		if (board.checkState(player, move, true)[-1] == -1) {return true;}
		return false;
	}
	
	
	//*********************************************
	//			TESTING
	//*********************************************
	
//	public static void main(String[] args){				
//		int[] values = {-6,13,-1,9,14,-19,-12,-18,20};
//		
//		
//		Board root = new Board(0);
//		for(int i=0;i<3;i++){
//			root.child.add(new Board(0));
//		}
//		int k=0;
//		for(int i=0;i<3;i++){
//			Board temp = root.child.get(i);
//			for(int j=0;j<3;j++){
//				temp.child.add(new Board(values[k]));
//				k++;
//			}
//		}
//		
//		
//		AlphaBeta ab = new AlphaBeta();
//		int va = ab.alphabeta(root);
//		
//		System.out.println("testing");
//		
//	}
//	
}