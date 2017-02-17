
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
	
	public checkRows(char player){
		/**
		*Checks for the case specified by the Alpha-Beta Search and returns number of possible moves
		*/
		int rowReturnCount[] = (0, 0, 0, 0, 0);
		
	
			rowReturnCount += checkHorizontal(rowReturnCount, player);
			rowReturnCount += checkVertical(rowReturnCount, player);
			rowReturnCount += checkHighLeftDiagonal(rowReturnCount, player);
			rowReturnCount += checkHighRightDiagonal(rowReturnCount, player);
			
		}
		return rowReturnCount;
	}
	
	private checkHorizontal(int[] rowReturnCount, char player){
		/**
		*Searches the entire string for horizontal rows 
		*The specified player can make and return the array
		*filled with the number of 5's 4Opens 4Closeds 3's and 2's
		*as (5's, 4O's, 4C's, 3's, 2's)
		*/
		int count = 0;
		int pieceCounter = 1;
		int boolean open = TRUE;
		int rowCounter = 1;
		int boolean drop = FALSE;
		
		while(count < masterBoard.length){
			//If it finds the player's piece, count the rows
			if(masterBoard.CharAt(count) && player){
				//Check if the previous is closed or open
				count--;
				//If the spot is NOT a space CHECK THIS FOR CORRECTNESS
				if(!(masterBoard.CharAt(count) && " ")){
					open = FALSE;
				}
				
				//Increase the count to search the next part
				count = count+2;
				//Increase the counter for pieces found
				pieceCounter++;
				
				for(rowCounter=1; rowCounter<=5; rowCounter++){
					//if reached end of the row, premature check and break(CHECK FOR OFF BY 1)
					if(count%rowLength!=0){
						rowCounter = 6;
						pieceCounterSwitch(rowReturnCounter, open);
						
					}else{	
						if(masterBoard.CharAt(count) && player){
							//Count up
							pieceCounter++;
							//Increment
							count++;
							
						}else{
							//If the Spot is NOT a space CHECK THIS FOR CORRECTNESS
							if(!(masterBoard.CharAt(count) && " "){
								//If closed at the beginning
								if(open == FALSE){
									drop = TRUE;
								}else{
									open ==FALSE;
									//force out
									rowCounter = 6;
								}
							}
						}
					}
				}
				//After for loop, determine size
				pieceCounterSwitch(rowReturnCounter, open);
			}
		}
	}

	private checkVertical(int[] rowReturnCount, char player){
		/**
		*Searches the entire string for columns
		*The specified player can make and return the array
		*filled with the number of 5's 4Opens 4Closeds 3's and 2's
		*as (5's, 4O's, 4C's, 3's, 2's)
		*/
		int count = 0;
		int pieceCounter = 1;
		int boolean open = TRUE;
		int rowCounter = 1;
		int boolean drop = FALSE;
		
		while(count < masterBoard.length){
			//If it finds the player's piece, count the columns
			if(masterBoard.CharAt(count) && player){
				//Check if the previous is closed or open
				count-rowLength;
				//If the spot is NOT a space CHECK THIS FOR CORRECTNESS
				if(!(masterBoard.CharAt(count) && " ")){
					open = FALSE;
				}
				
				//Increase the count to search the next part
				count = count+(2*rowLength);
				//Increase the counter for pieces found
				pieceCounter++;
				
				for(rowCounter=1; rowCounter<=5; rowCounter++){
					//if reached end of the column, premature check and break(CHECK FOR OFF BY 1)
					if(count+rowLength > masterBoard.length){
						rowCounter = 6;
						pieceCounterSwitch(rowReturnCounter, open);
						
					}else{	
						if(masterBoard.CharAt(count) && player){
							//Count up
							pieceCounter++;
							//Increment
							count+rowLength;
							
						}else{
							//If the Spot is NOT a space CHECK THIS FOR CORRECTNESS
							if(!(masterBoard.CharAt(count) && " "){
								//If closed at the beginning
								if(open == FALSE){
									drop = TRUE;
								}else{
									open ==FALSE;
									//force out
									rowCounter = 6;
								}
							}
						}
					}
				}
				//After for loop, determine size
				pieceCounterSwitch(rowReturnCounter, open);
			}
		}
	}
	private checkHighLeftDiagonal(int[] rowReturnCount, char player){
		/**
		*Searches the entire string for high left diagonal rows 
		*The specified player can make and return the array
		*filled with the number of 5's 4Opens 4Closeds 3's and 2's
		*as (5's, 4O's, 4C's, 3's, 2's)
		*/
		int count = 0;
		int pieceCounter = 1;
		int boolean open = TRUE;
		int rowCounter = 1;
		int boolean drop = FALSE;
		
		int count = 0;
		int pieceCounter = 1;
		int boolean open = TRUE;
		int rowCounter = 1;
		int boolean drop = FALSE;
		
		while(count < masterBoard.length){
			//If it finds the player's piece, count the diagonals
			if(masterBoard.CharAt(count) && player){
				//Check if the previous is closed or open
				count= count-rowLength-1;
				//If the spot is NOT a space CHECK THIS FOR CORRECTNESS
				if(!(count <0)){
					if(!(masterBoard.CharAt(count) && " ")){
						open = FALSE;
					}
				}
				//Increase the count to search the next part
				count = count+((2*rowLength)+2);
				//Increase the counter for pieces found
				pieceCounter++;
				
				for(rowCounter=1; rowCounter<=5; rowCounter++){
					//	if reached end of the diagonal, premature check and break(CHECK FOR OFF BY 1)
					if(count % rowLength > 0){
						rowCounter = 9;
						drop = TRUE;
					}else{	
						if(masterBoard.CharAt(count) && player){
							//Count up
							pieceCounter++;
							//Increment
							count+rowLength+1;
							
						}else{
							//If the Spot is NOT a space CHECK THIS FOR CORRECTNESS
							if(!(masterBoard.CharAt(count) && " "){
								//If closed at the beginning
								if(open == FALSE){
									drop = TRUE;
								}else{
									open ==FALSE;
									//force out
									rowCounter = 6;
								}
							}
						}
					}
				}
			//After for loop, determine size
			pieceCounterSwitch(rowReturnCounter, open);
		}
	}
	private checkHighRightDiagonal(int[] rowReturnCount, char player)	
		/**
		*Searches the entire string for high right diagonal rows 
		*The specified player can make and return the array
		*filled with the number of 5's 4Opens 4Closeds 3's and 2's
		*as (5's, 4O's, 4C's, 3's, 2's)
		*/
		int count = 0;
		int pieceCounter = 1;
		int boolean open = TRUE;
		int rowCounter = 1;
		int boolean drop = FALSE;
		
		while(count < masterBoard.length){
			//If it finds the player's piece, count the diagonals
			if(masterBoard.CharAt(count) && player){
				//Check if the previous is closed or open
				count= count-rowLength+1;
				//If the spot is NOT a space CHECK THIS FOR CORRECTNESS
				if(!(count <0)){
					if(!(masterBoard.CharAt(count) && " ")){
						open = FALSE;
					}
				}
				//Increase the count to search the next part
				count = count+((2*rowLength)-2);
				//Increase the counter for pieces found
				pieceCounter++;
				
				for(rowCounter=1; rowCounter<=5; rowCounter++){
					//	if reached end of the diagonal, premature check and break(CHECK FOR OFF BY 1)
					if(count % rowLength = rowlength-1){
						rowCounter = 9;
						drop = TRUE;
					}else{	
						if(masterBoard.CharAt(count) && player){
							//Count up
							pieceCounter++;
							//Increment
							count+rowLength-1;
							
						}else{
							//If the Spot is NOT a space CHECK THIS FOR CORRECTNESS
							if(!(masterBoard.CharAt(count) && " "){
								//If closed at the beginning
								if(open == FALSE){
									drop = TRUE;
								}else{
									open ==FALSE;
									//force out
									rowCounter = 6;
								}
							}
						}
					}
				}
			//After for loop, determine size
			pieceCounterSwitch(rowReturnCounter, open);
		}
	}

	private void pieceCounterSwitch(rowReturnCount, open){
		/**
		*Switch Case for selecting what to shove inside rowReturnCount
		*/
		switch(pieceCounter){
							case 5:
								if(drop == FALSE){
									rowReturnCount[0] = rowReturnCount[0]+1;
									drop == FALSE;
									break;
								}
							case 4:
								if(drop == FALSE){
									if(open == TRUE){
									rowReturnCount[1] = rowReturnCount[1]+1;
									drop == FALSE;
									break;
									}
									if(open == FALSE){
										rowReturnCount[2] = rowReturnCount[2]+1;
										drop == FALSE;
										break;
									}
								}
							case 3:
								if(drop == FALSE){
									rowReturnCount[3] = rowReturnCount[3]+1;
									drop == FALSE;
									break;
								}
							case 2:
								if(drop == FALSE){
									rowReturnCount[4] = rowReturnCount[4]+1;
									drop == FALSE;
									break;
								}
							default:
								drop == FALSE;
		}
	}