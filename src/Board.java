import java.util.ArrayList;

public class Board{
	private int size;
	private char us;
	private char[][] gameboard;
	
	private String[] w = {"ww","www","wwww","wwwww"};
	private String[] b = {"bb","bbb","bbbb","bbbbb"};
	
	public Board(Board board){
		gameboard = board.gameboard;
		size = board.size;
		us = board.us;
	}
	
	public Board(char[][] gameboard, int size, char us){
		this.gameboard = gameboard;
		this.size = size;
		this.us = us;
	}
	
	public ArrayList<String> getMoves(){
		ArrayList<String> moves = new ArrayList<String>();
		
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if(gameboard[i][j] == ' '){
					moves.add(i+ " " +j);
				}
			}
		}
		return moves;
	}
	
	public boolean checkwin(char p, int[] move){
		int i,j;
		String[] player = (p == 'w') ? w:b;
		
		String test = "";
		
		//check row win
		test = new String(gameboard[move[0]]);
		if(test.contains(player[4])){ return true; }
		
		//check col win
		for(i=0; i<size; i++){
			test += Character.toString(gameboard[i][move[1]]);
		}
		if(test.contains(player[4])){ return true; }
		
		//check down diag win
		i = move[0] - move[1];
		j = 0;
		
		if(i<0){
			j = -i;
			i = 0;
		}
		while(i<size && j<size){
			test += Character.toString(gameboard[i][j]);
			i++;
			j++;
		}
		if(test.contains(player[4])){ return true; }
		
		//check up diag
		i = move[0] + move[1];
		j = 0;
		
		if(i>size){
			int d = i - size + 1;
			i -= d;
			j += d;
		}
		while(i>0 && j<size){
			test += Character.toString(gameboard[i][j]);
			i--;
			j++;
		}
		if(test.contains(player[4])){ return true; }
		
		return false;
	}
	
	public int checkState(char player, int len){
		int count = 0;
		//TODO *******************************************
		return count;
	}

	public int getSize() {
		return size;
	}

	public boolean isValid(String move) {
		int i = Character.getNumericValue(move.charAt(0));
		int j = Character.getNumericValue(move.charAt(1));
		if(gameboard[i][j] == ' '){ return true; }
		return false;
	}
	
	public void setMove(int[] move, char player){
		gameboard[move[0]][move[1]] = player;
	}
}