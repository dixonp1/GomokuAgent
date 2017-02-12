
public class Board {
	String masterBoard;
	char player;
	int boardRow = 0;
	
	public Board(String s, char c, int i)
		masterBoard = s;
		player = c;
		boardRow = i;
	}
	
	public updateBoard(int location, int player){
		/**
		*Updates the master board with the location the player chose
		*/
		masterBoard.CharAt(location) = player;
	}
	
	public int Array locationOfSpaces(){
		/**
		*Checks each location on the board for spaces available and returns the locations in an array
		*/
		int Array[];
		int arrayCounter = 0;
		for(int i = 0; i<s.Length(); i++;){
			if(s.CharAt(i))&& " "{
				array[arrayCounter] = i;
			}
		} 	
		return array;
	}
	
	public checkRows(int rowAmount, boolean openClose, char player){
		/**
		*Checks for the case specified by the Alpha-Beta Search and returns number of possible moves
		*/
		int rowReturnCount = 0;
		
		
		switch(rowAmount){
			case: 4{
				rowReturnCount += checkBooleanHorizontal(rowAmount, openClose, player);
				rowReturnCount += checkBooleanVertical(rowAmount, openClose, player);
				rowReturnCount += checkBooleanHighLeftDiagonal(rowAmount, openClose, player);
				rowReturnCount += checkBooleanHighRightDiagonal(rowAmount, openClose, player);
				break;
			}
			
			default:{
				rowReturnCount += checkHorizontal(rowAmount, player);
				rowReturnCount += checkVertical(rowAmount, player);
				rowReturnCount += checkHighLeftDiagonal(rowAmount, player);
				rowReturnCount += checkHighRightDiagonal(rowAmount, player);
			}
			
		}
		return rowReturnCount;
	}
	
	private checkHorizontal(int rowAmount, char player){
		/**
		*Searches the entire string for horizontal rows the specified player can make and return the number of 5's 4Opens 4Closeds 3's and 2's
		*/
		int count = 0;
		int pieceCounter = 0;
		while(count < s.length){
			//If it finds the player's piece, count the rows
			if(masterBoard.CharAt(count) && player){
				//Increase the count to search the next part
				count++;
				//Increase the counter for pieces found
				pieceCounter = 1;
				//Continue searching until either matches the rowAmount, along with being open on one or the other, otherwise break
				//Check before the found one, if open keep in memory for fully closed
				//Check middle for the row itself. if no breaks, continue, if breaks, break out as it doesn't match query
				//Check end for block. If both sides are blocked, do not count it to the return.
				for(rowCounter=0; rowCounter<=i; i++){
					if(board+(count*sizeof(char)) && search){
						count++;
						counter++;
					}
				}
				if(counter && i){
					rowCountReturn++;
					else{
						count = count-i;
					}
				}
				
			}

		}
	}

	private checkVertical(int rowAmount){
		
	}
	private checkHighLeftDiagonal(int rowAmount){
		
	}
	private checkHighRightDiagonal(int rowAmount{
	
	)
	
	private checkBooleanHorizontal(int rowAmount, boolean openClose){
		switch(openClose){
			case(TRUE):{
				
			}
			case(FALSE:{
				
			)
		}
		return;
	}
	
	private checkBooleanVertical(int rowAmount, boolean openClose){
		switch(openClose){
			case(TRUE):{
				
			}
			case(FALSE:{
				
			)
		}
		return;
		}
	}
	private checkBooleanHighLeftDiagonal(int rowAmount, boolean openClose){
		switch(openClose){
			case(TRUE):{
				
			}
			case(FALSE:{
				
			)
		}
		return;
		}
	}
	private checkBooleanHighRightDiagonal(int rowAmount, boolean openClose){
		switch(openClose){
			case(TRUE):{
				
			}
			case(FALSE:{
				
			)
		}
		return;
		}
	}
}
