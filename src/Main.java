import java.io.*;
import java.net.*;

public class Main{
   
   protected Socket myClient = null;//our client socket.
   protected PrintWriter os = null;
   protected BufferedReader is = null;//Input stream.
   protected String gs = null;//GameState.

   public static void main(String args[]) throws IOException{
   
   try{
   Main main = new Main("localhost", 17033);//Object of whole class with everything (all variables, etc) in it.
   main.play();
   }catch (Exception e){
      e.printStackTrace();//Prints out all exceptions from entire program.
   }//End try catch.
//Declaration section.
//myClient: 
//os: output stream.
//is: input stream.
   }
   
   public Main(String h, int p) throws Exception{//Constructor sets it as a clean slate-that loops thru server and boards and sends and receives.
      socketConnect(h, p);//Sets up socket.
      gs = new String();//Set up-setting to an empty string.
   }
   
   public void play(){
      while (true){
      Board newBoard = readIn();//This reads in new board from server and sends to.
      if (gs != "continuing"){
          System.out.println("Game is over.");
          break;
          }
      String move = newBoard.processBoard();//Grabbing move from processBoard
      moveSend(move);//Sends move (# #) to Server.
      }
      
//Game over clean up-close output and input stream before closing socket.
   try{
      os.close();
      is.close();
      myClient.close();      
   }catch (UnknownHostException e){
      System.err.println("Trying to connect to unknown host: " + e);
   }catch (IOException e){
      System.err.println("IOException: " + e);
   }
   }
   
   public void socketConnect(String h, int p)throws Exception{//this allows for graceful failure.
//Initialization section:
//Try to open socket on port 17033.
//Try to open input and output streams.
   try{
      myClient = new Socket(h, p);
      os = new PrintWriter(myClient.getOutputStream(), true);
      is = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
   }catch (UnknownHostException e){
      System.err.println("Don't know about host: ");
   }catch (IOException e){
      System.err.println("Couldn't get I/O for the connection to: ");
   }
   }
   
   public Board readIn()throws Exception{
   String s;
   char c;
   int i, r;
   gs = is.readLine();//reads in games(1)First Line-game status (continuing, win, lose, draw, forfeit-move, forfeit-time)
   s = is.readLine();//this reads in first line of board.(2)Second Line-series of lines for as many rows as there are in the game board-characters are x, o, or space.
      for(r=0; r<s.length()-1; r++){
      s += is.readLine();
      }    
   c = is.readLine().charAt(0);  //Third Line-single character specifying which player (x or o) is to play next.its telling me I'm next.
      
	Board bd = new Board(s, c, s.length());//Board to Noctis.gridIn is buffered reader..
	return bd;
    }

       public void moveSend(String command)throws Exception{//helper method that i send string to 
	os.println(command);//sends command out to printwriter...like me to typing output to socket.
    }
   
   
}//End Main.
/*
//I added this method to return the move that main needs.
//Main will call processBoard on a newly created board that has the masterBoard, player, and boardRow already populated.
   public String processBoard(){
      //this. will call the methods in Board and return a move to Main using the this keyword.
      return "0 0";
   }
   */