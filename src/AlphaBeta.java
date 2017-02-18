import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private double eval(Board board, int player) {
		int fourRow = board.checkState(player, 4);
		int threeRow = board.checkState(player, 3);
		int twoRow = board.checkState(player, 2);

		return fourRow * 1 + threeRow * 0.1 + twoRow * 0.05;
	}

	public String alphabetasearch(Board board) {
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
		int[] moveList = board.getMoves(); 
		
//		if(board.child.size() == 0) return board.value;
//		ArrayList<Board> child = board.child;		
		
		//check cutoff tests
		//return current move and heuristic if TRUE
		if (cutoff_test(board, depth, player)) {
			Object[] move = {eval(board, player), moveList[0]};
			return move;
		}
		
		double bestValue = Double.NEGATIVE_INFINITY;
//		int bestValue = -100;
		int position = 0;
		
		
		for (int i = 0; i < moveList.length; i++) {
			Object[] v = -minimaxValue(board.setMove(moveList[i]), -beta, 
									-alpha, depth-1, -player);
			
//			int v = -minimaxValue(child.get(i), -beta, -alpha, depth, player);
			
			//bestValue := max(bestValue, v)
			if(bestValue < (Double)v[0]){
				bestValue = (Double)v[0];
				//set new best move
				position = moveList[i];
			}
			
//			if(bestValue < v){
//				bestValue = v;
//			}
			
			//update alpha
			alpha = Math.max(alpha,(Double)v[0]);
			
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

	private boolean cutoff_test(Board board, int depth, int player) {
		if (depth == 0) {return true;}
		if (turnends) {return true;}
		if (board.checkwin(player)) {return true;}
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