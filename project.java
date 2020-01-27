import java.util.*;

class TicTacToebtwHumans
{
   public char [][] board = new char[3][3]; 
   Scanner in = new Scanner(System.in);
   public TicTacToebtwHumans(String s){
     
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            board[i][j] = ' ';
        }  
       }
       System.out.println("You started the game between Human vs " + s);
   }

   public void displayBoard()
   {
      System.out.println("---------");
      System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
      System.out.println("---------");
      System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
      System.out.println("---------");
      System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
      System.out.println("---------");
   }
   public void gameStart()
   {
           int i, j;
           boolean turn = true;
           char winner = 'w';
           while( winner == 'w' && !draw()){
               if(turn){
                   System.out.println("Player 1's turn, Enter the coordinates");
                   i = in.nextInt();
                   j = in.nextInt();
                   board[i][j] = 'X';
               }
               else{
                  System.out.println("Player 2's turn, Enter the coordinates");
                  i = in.nextInt();
                  j = in.nextInt();
                  board[i][j] = 'O';
               }
               turn = !turn;
               displayBoard();
               winner = win();
               if(winner != 'w')
               System.out.println( winner + " is the winnner");
            }
    }          
  
   public char win()
   {
    for (int a = 0; a < 8; a++) {
        switch (a) {
        case 0:
             
            if(board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') return 'X';
            else if( board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O' ) return 'O';
             
            break;
        case 1:
             
            if(board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') return 'X';
            else if( board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O' ) return 'O';
             break;
        case 2:
            if(board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') return 'X';
            else if( board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O' ) return 'O';
            break;
        case 3:
            
            if(board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') return 'X';
            else if( board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O' ) return 'O';
            break;
        case 4:
             
            if(board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') return 'X';
            else if( board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O' ) return 'O';
            break;
        case 5:
             
            if(board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') return 'X';
            else if( board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O' ) return 'O';
            break;
        case 6:
            
            if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') return 'X';
            else if( board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O' ) return 'O';
            break;
        case 7:
            
            if(board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X') return 'X';
            else if( board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O' ) return 'O';
            break;
        }
          
    }
    return 'w'; 
   }
    public boolean draw()
    {
        for(int i = 0; i < 3; i++)
         for(int j = 0; j < 3; j++)
          if(board[i][j] == ' ') return false;
        
        System.out.println("It's a draw");
        return true;  
    }

}

public class project
{
    public static void main(String args[]){
     System.out.println("enter 1 to start the game Between human and human");  
     Scanner in = new Scanner(System.in);
     int gametype = in.nextInt();
     if(gametype == 1){
         TicTacToebtwHumans t = new TicTacToebtwHumans("Human");
         t.displayBoard();
         t.gameStart();
         }
     }
}
