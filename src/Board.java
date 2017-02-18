import java.util.ArrayList;

public class Board{
	private int size;
	private char us;
	private char them;
	private char[][] gameboard;
	
	private String wwin = "wwwww";
	private String[][] w = {{" wwb", " ww ", "bww "},
							{" wwwb", " www ", "bwww "},
							{" wwwwb", " wwww ", "bwwww "}};
	private String bwin = "bbbbb";
	private String[][] b = {{" bbw", " bb ", "wbb "},
							{" bbbw", " bbb ", "wbbb "},
							{" bbbbw", " bbbb ", "wbbbb "}};
	
	public Board(Board board){
		gameboard = board.gameboard;
	}
	
	public Board(char[][] gameboard, int size, char us, char them){
		this.gameboard = gameboard;
		this.size = size;
		this.us = us;
		this.them = them;
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
	
	public int[] checkState(int ip, String m, boolean checkwin){
		int i,j;
		int[] count = {0,0,0,0};
		int[] move = convertToInt(m);
		char p = playerToChar(ip);
		String[][] player = b;
		String pwin = bwin;
		
		if(p == 'w'){
			player = w;
			pwin = wwin;
		}
		
		String test = "";
		
		//check row 
		test = new String(gameboard[move[0]]);
		count = checkmatch(test, pwin, player, checkwin);
		
		//check col 
		for(i=0; i<size; i++){
			test += Character.toString(gameboard[i][move[1]]);
		}
		count = checkmatch(test, pwin, player, checkwin);
		
		//check down diag 
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
		count = checkmatch(test, pwin, player, checkwin);
		
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
		count = checkmatch(test, pwin, player, checkwin);
		
		return count;
	}
	
	private int[] checkmatch(String test, String pwin, String[][] player, boolean checkwin){
		int[] count = {0,0,0,0};
		int i,j,k,m;
		int winsize = 6;
		if(checkwin && test.contains(pwin)){ 
			count[-1] = 1;
			return count; 
		}else{
			String window="";
			boolean matchfound=false;
			for(i=0,j=winsize;j<size;i++,j++){
				window = test.substring(i, j);
				for(k=2;k>0;k--){
					for(m=2;m<0;m--){
						if(window.contains(player[k][m])){
							count[k]++;
							matchfound = true;
						}
						if(matchfound){ break;}
					}
					if(matchfound){ 
						i += player[k][m].length()-1;
						j += player[k][m].length()-1;
						break; 
					}
				}
			}
		}
		return count;
	}

	public int getSize() {
		return size;
	}

	public boolean isValid(String move) {
		int[] m = convertToInt(move);
		if(gameboard[m[0]][m[1]] == ' '){ return true; }
		return false;
	}
	
	public void setMove(String move, int p){
		int[] m = convertToInt(move);
		char player = playerToChar(p);
		gameboard[m[0]][m[1]] = player;
	}
	
	private int[] convertToInt(String move){
		int i = Character.getNumericValue(move.charAt(0));
		int j = Character.getNumericValue(move.charAt(1));
		int[] m = {i,j};
		return m;
	}
	
	private char playerToChar(int p){
		return (p==1) ? us:them;
	}
}