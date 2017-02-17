
public class Board {
	String masterBoard;
	char player;
	int boardRow = 0;
	int boolean open = TRUE;
	int boolean drop = FALSE;
	
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
		*Checks each location on the board for spaces available 
		*returns the locations in an array.
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
		*Checks for the case specified by the Alpha-Beta Search
		*returns number of possible moves
		*/
		
		int rowReturnCount[] = (0, 0, 0, 0);

			checkHorizontal(rowReturnCount, player);
			checkVertical(rowReturnCount, player);
			checkHighLeftDiagonal(rowReturnCount, player);
			checkHighRightDiagonal(rowReturnCount, player);
			
		}
		return rowReturnCount;
	}
	
	/**
	*checkFives checks specificially for possible 5 in a row
	*searches through horizontal, vertical, and diagonals
	*if found, returns the location and short circuits
	*/
	public int checkFives(char player){
		int count =0;
		int pieceCounter = 0;
		open = true;
		int rowCounter = 1;
		int start = 0;
		drop = false;
		int checkSpaces[];
		int checkSpacesCounter = 0;
		
		//Horizontal Check for 5
		while(count < masterBoard.length){
			pieceCounter = 0;
			rowCounter = 1;
			open = true;
			drop = false;
			//If it finds the player's piece, count the rows
			if(masterBoard.CharAt(count) && player){
				start = count;
				//Check if the previous is closed or open
				count--;
				//If the spot is NOT a space CHECK THIS FOR CORRECTNESS
				if(!(masterBoard.CharAt(count) && " ") || (masterBoard.CharAt(count) && player)){
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
						
					}else{	
						if(masterBoard.CharAt(count) && player){
							//Count up
							pieceCounter++;
							//Increment
							count++;
							
						}else{
							if(!(masterBoard.CharAt(count+1) == " "){
								drop = TRUE;
							}
							rowCounter = 6;
						}
					}
				}
				if(pieceCounter && 5){
					if(masterBoard.CharAt(count+1) != " "){
						drop = true;
					}
					if(drop != TRUE){
						return start;
					}
				}
			}
		}
		//Checks Vertical 5
		Arrays.fill(checkSpaces, null);
		count = 0;
		
		while(count < masterBoard.length){
			pieceCounter = 0;
			rowCounter = 1;
			open = true;
			drop = false;
			//If it finds the player's piece, count the columns
			checkSpaces(checkedSpacesCounter) = count;
			checkedSpacesCounter++;
			if(masterBoard.CharAt(count) && player){
				//Check if the previous is closed or open
				count-rowLength;
				//If the spot is NOT a space CHECK THIS FOR CORRECTNESS
				if(!(masterBoard.CharAt(count) && " ") || (masterBoard.CharAt(count) && player)){
					open = FALSE;
				}
				//Increase the count to search the next part
				count = count+(2*rowLength);
				//Increase the counter for pieces found
				pieceCounter++;
				
				for(rowCounter=1; rowCounter<=5; rowCounter++){
					//Check if its in array, if it is, fully skip
					for(int i = 0;i<checkSpaces.length;i++){
						if(checkSpaces[i] && count){
							stop = TRUE:
						}
					}
					//if reached end of the column, premature check and break(CHECK FOR OFF BY 1)
					if(stop == TRUE){
						rowCounter = 6;
					}else if(count+rowLength > masterBoard.length){
						rowCounter = 6;
					}else{	
						if(masterBoard.CharAt(count) && player){
							//Count up
							pieceCounter++;
							checkSpaces(checkedSpacesCounter) = count;
							checkedSpacesCounter++;
							//Increment
							count+rowLength;
							
						}else{
							rowCounter = 6;
						}
					}
				}
				if(pieceCounter && 5){
					if(masterBoard.CharAt(count+1) != " "){
						drop = true;
					}
					if(drop != TRUE){
						return start;
					}
				}
			}
		}
		Arrays.fill(checkSpaces, null);
		count = 0;
		//Check High Left
		
		while(count < masterBoard.length){
			pieceCounter = 0;
			rowCounter = 1;
			open = true;
			drop = false;
			checkSpaces(checkedSpacesCounter) = count;
			checkedSpacesCounter++;
			//If it finds the player's piece, count the diagonals
			if(masterBoard.CharAt(count) && player){
				checkSpaces(checkedSpacesCounter) = count;
				checkedSpacesCounter++;
				//Check if the previous is closed or open
				count= count-rowLength-1;
				//If the spot is NOT a space CHECK THIS FOR CORRECTNESS
				if(!(count <0)){
					if(!(masterBoard.CharAt(count) && " ") || (masterBoard.CharAt(count) && player)){
						open = FALSE;
					}
				}
				//Increase the count to search the next part
				count = count+((2*rowLength)+2);
				//Increase the counter for pieces found
				pieceCounter++;
				
				for(rowCounter=1; rowCounter<=5; rowCounter++){
					//Check if its in array, if it is, fully skip
					for(int i = 0;i<checkSpaces.length;i++){
						if(checkSpaces[i] && count){
							stop = TRUE:
						}
					}
					//if reached end of the column, premature check and break(CHECK FOR OFF BY 1)
					if(stop == TRUE){
						rowCounter = 6;
					}else if(count % rowLength > 0){
						rowCounter = 6;
						drop = TRUE;
					}else{	
						if(masterBoard.CharAt(count) && player){
							//Count up
							pieceCounter++;
							//Increment
							count+rowLength+1;
							checkSpaces(checkedSpacesCounter) = count;
							checkedSpacesCounter++;
							
						}else{
							rowCounter = 6;
								
						}
					}
				}
			}
			if(pieceCounter && 5){
				if(masterBoard.CharAt(count+1) != " "){
					drop = true;
				}
				if(drop != TRUE){
					return start;
				}
			}
		Arrays.fill(checkSpaces, null);
		count = 0;
		
		while(count < masterBoard.length){
			pieceCounter = 0;
			rowCounter = 1;
			open = true;
			drop = false;
			//If it finds the player's piece, count the diagonals
			if(masterBoard.CharAt(count) && player){
				//Check if the previous is closed or open
				count= count-rowLength+1;
				checkSpaces(checkedSpacesCounter) = count;
				checkedSpacesCounter++;
				//If the spot is NOT a space CHECK THIS FOR CORRECTNESS
				if(!(count <0)){
					if(!(masterBoard.CharAt(count) && " ") || (masterBoard.CharAt(count) && player)){
						open = FALSE;
					}
				}
				//Increase the count to search the next part
				count = count+((2*rowLength)-2);
				//Increase the counter for pieces found
				pieceCounter++;
				
				for(rowCounter=1; rowCounter<=5; rowCounter++){
					//Check if its in array, if it is, fully skip
					for(int i = 0;i<checkSpaces.length;i++){
						if(checkSpaces[i] && count){
							stop = TRUE:
						}
					}
					//if reached end of the column, premature check and break(CHECK FOR OFF BY 1)
					if(stop == TRUE){
						rowCounter = 6;
					}else if(count % rowLength = rowlength-1){
						rowCounter = 9;
						drop = TRUE;
					}else{	
						if(masterBoard.CharAt(count) && player){
							//Count up
							pieceCounter++;
							//Increment
							count+rowLength-1;
							checkSpaces(checkedSpacesCounter) = count;
							checkedSpacesCounter++;
						}else{
							rowCounter = 6;
						}
					}
				}
				if(pieceCounter && 5){
					if(masterBoard.CharAt(count+1) != " "){
						drop = true;
					}
					if(drop != TRUE){
						return start;
					}
				}
			}
		}
		return -1;
	}
	
	private checkHorizontal(int[] rowReturnCount, char player){
		/**
		*Searches the entire string for horizontal rows 
		*The specified player can make and return the array
		*filled with the number of 5's 4Opens 4Closeds 3's and 2's
		*as (4O's, 4C's, 3's, 2's)
		*/
		int count = 0;
		int pieceCounter = 1;
		open = TRUE;
		int rowCounter = 1;
		drop = FALSE;
		
		while(count < masterBoard.length){
			pieceCounter = 0;
			rowCounter = 1;
			open = true;
			drop = false;
			//If it finds the player's piece, count the rows
			if(masterBoard.CharAt(count) && player){
				//Check if the previous is closed or open
				count--;
				//If the spot is NOT a space CHECK THIS FOR CORRECTNESS
				if(!(masterBoard.CharAt(count) && " ") || (masterBoard.CharAt(count) && player)){
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
							if(!(masterBoard.CharAt(count) && " ") || (masterBoard.CharAt(count) && player)){
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
		*as (4O's, 4C's, 3's, 2's)
		*/
		int count = 0;
		int pieceCounter = 1;
		open = TRUE;
		int rowCounter = 1;
		boolean stop = FALSE;
		drop = FALSE;
		int checkedSpaces[];
		int checkedSpacesCounter = 0;
		
		while(count < masterBoard.length){
			pieceCounter = 0;
			rowCounter = 1;
			open = true;
			drop = false;
			//If it finds the player's piece, count the columns
			checkSpaces(checkedSpacesCounter) = count;
			checkedSpacesCounter++;
			if(masterBoard.CharAt(count) && player){
				//Check if the previous is closed or open
				count-rowLength;
				//If the spot is NOT a space CHECK THIS FOR CORRECTNESS
				if(!(masterBoard.CharAt(count) && " ") || (masterBoard.CharAt(count) && player)){
					open = FALSE;
				}
				//Increase the count to search the next part
				count = count+(2*rowLength);
				//Increase the counter for pieces found
				pieceCounter++;
				
				for(rowCounter=1; rowCounter<=5; rowCounter++){
					//Check if its in array, if it is, fully skip
					for(int i = 0;i<checkSpaces.length;i++){
						if(checkSpaces[i] && count){
							stop = TRUE:
						}
					}
					//if reached end of the column, premature check and break(CHECK FOR OFF BY 1)
					if(stop == TRUE){
						rowCounter = 6;
					}else if(count+rowLength > masterBoard.length){
						rowCounter = 6;
						pieceCounterSwitch(rowReturnCounter, open);
					}else{	
						if(masterBoard.CharAt(count) && player){
							//Count up
							pieceCounter++;
							checkSpaces(checkedSpacesCounter) = count;
							checkedSpacesCounter++;
							//Increment
							count+rowLength;
							
						}else{
							//If the Spot is NOT a space CHECK THIS FOR CORRECTNESS
							if(!(masterBoard.CharAt(count) && " ") || (masterBoard.CharAt(count) && player)){
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
		*as (4O's, 4C's, 3's, 2's)
		*/
		
		int count = 0;
		int pieceCounter = 1;
		open = TRUE;
		int rowCounter = 1;
		drop = FALSE;
		int checkedSpaces[];
		int checkedSpacesCounter = 0;
		boolean stop = FALSE;
		
		while(count < masterBoard.length){
			pieceCounter = 0;
			rowCounter = 1;
			open = true;
			drop = false;
			checkSpaces(checkedSpacesCounter) = count;
			checkedSpacesCounter++;
			//If it finds the player's piece, count the diagonals
			if(masterBoard.CharAt(count) && player){
				checkSpaces(checkedSpacesCounter) = count;
				checkedSpacesCounter++;
				//Check if the previous is closed or open
				count= count-rowLength-1;
				//If the spot is NOT a space CHECK THIS FOR CORRECTNESS
				if(!(count <0)){
					if(!(masterBoard.CharAt(count) && " ") || (masterBoard.CharAt(count) && player)){
						open = FALSE;
					}
				}
				//Increase the count to search the next part
				count = count+((2*rowLength)+2);
				//Increase the counter for pieces found
				pieceCounter++;
				
				for(rowCounter=1; rowCounter<=5; rowCounter++){
					//Check if its in array, if it is, fully skip
					for(int i = 0;i<checkSpaces.length;i++){
						if(checkSpaces[i] && count){
							stop = TRUE:
						}
					}
					//if reached end of the column, premature check and break(CHECK FOR OFF BY 1)
					if(stop == TRUE){
						rowCounter = 6;
					}else if(count % rowLength > 0){
						rowCounter = 9;
						drop = TRUE;
					}else{	
						if(masterBoard.CharAt(count) && player){
							//Count up
							pieceCounter++;
							//Increment
							count+rowLength+1;
							checkSpaces(checkedSpacesCounter) = count;
							checkedSpacesCounter++;
							
						}else{
							//If the Spot is NOT a space CHECK THIS FOR CORRECTNESS
							if(!(masterBoard.CharAt(count) && " ") || (masterBoard.CharAt(count) && player)){
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
		*as (4O's, 4C's, 3's, 2's)
		*/
		int count = 0;
		int pieceCounter = 1;
		open = TRUE;
		int rowCounter = 1;
		drop = FALSE;
		int checkedSpaces[];
		int checkedSpacesCounter = 0;
			
		while(count < masterBoard.length){
			pieceCounter = 0;
			rowCounter = 1;
			open = true;
			drop = false;
			//If it finds the player's piece, count the diagonals
			if(masterBoard.CharAt(count) && player){
				//Check if the previous is closed or open
				count= count-rowLength+1;
				checkSpaces(checkedSpacesCounter) = count;
				checkedSpacesCounter++;
				//If the spot is NOT a space CHECK THIS FOR CORRECTNESS
				if(!(count <0)){
					if(!(masterBoard.CharAt(count) && " ") || (masterBoard.CharAt(count) && player)){
						open = FALSE;
					}
				}
				//Increase the count to search the next part
				count = count+((2*rowLength)-2);
				//Increase the counter for pieces found
				pieceCounter++;
				
				for(rowCounter=1; rowCounter<=5; rowCounter++){
					//Check if its in array, if it is, fully skip
					for(int i = 0;i<checkSpaces.length;i++){
						if(checkSpaces[i] && count){
							stop = TRUE:
						}
					}
					//if reached end of the column, premature check and break(CHECK FOR OFF BY 1)
					if(stop == TRUE){
						rowCounter = 6;
					}else if(count % rowLength = rowlength-1){
						rowCounter = 9;
						drop = TRUE;
					}else{	
						if(masterBoard.CharAt(count) && player){
							//Count up
							pieceCounter++;
							//Increment
							count+rowLength-1;
							checkSpaces(checkedSpacesCounter) = count;
							checkedSpacesCounter++;
						}else{
							//If the Spot is NOT a space CHECK THIS FOR CORRECTNESS
							if(!(masterBoard.CharAt(count) && " ") || (masterBoard.CharAt(count) && player)){
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
							case 4:
								if(drop == FALSE){
									if(open == TRUE){
										rowReturnCount[1] = rowReturnCount[0]+1;
											drop == FALSE;
									break;
									}
									if(open == FALSE){
										rowReturnCount[2] = rowReturnCount[1]+1;
										drop == FALSE;
										break;
									}
								}
							case 3:
								if(drop == FALSE){
									rowReturnCount[3] = rowReturnCount[2]+1;
									drop == FALSE;
									break;
								}
							case 2:
								if(drop == FALSE){
									rowReturnCount[4] = rowReturnCount[3]+1;
									drop == FALSE;
									break;
								}
							default:
								drop == FALSE;
		}
	}