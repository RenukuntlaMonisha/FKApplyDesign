import java.util.*;

class TicTacToebtwHumans
{
   public char [][] board = new char[3][3]; 
   Scanner in = new Scanner(System.in);
   public TicTacToebtwHumans(){
     
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            board[i][j] = ' ';
        }  
       }
       
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
           boolean turn = true, ifdraw = false;
           char winner = 'w';
           while( winner == 'w' && !ifdraw ){
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
               ifdraw = draw(board, 0, 0);
               if(ifdraw == true)System.out.println("It's a draw");
               winner = win(board, 0, 0);
               if(winner != 'w')
               System.out.println( winner + " is the winnner");
            }
    }          
  
   public char win(char[][] board, int x, int y)
   {
    for (int a = 0; a < 8; a++) {
        switch (a) {
        case 0:
             
            if(board[0 + x][0 + y] == 'X' && board[0 + x][1 + y] == 'X' && board[0 + x][2 + y] == 'X') return 'X';
            else if( board[0 + x][0 + y] == 'O' && board[0 + x][1 + y] == 'O' && board[0 + x][2 + y] == 'O' ) return 'O';
             
            break;
        case 1:
             
            if(board[1 + x][0 + y] == 'X' && board[1 + x][1 + y] == 'X' && board[1 + x][2 + y] == 'X') return 'X';
            else if( board[1 + x][0 + y] == 'O' && board[1 + x][1 + y] == 'O' && board[1 + x][2 + y] == 'O' ) return 'O';
             break;
        case 2:
            if(board[2 + x][0 + y] == 'X' && board[2 + x][1 + y] == 'X' && board[2 + x][2 + y] == 'X') return 'X';
            else if( board[2 + x][0 + y] == 'O' && board[2 + x][1 + y] == 'O' && board[2 + x][2 + y] == 'O' ) return 'O';
            break;
        case 3:
            
            if(board[0 + x][0 + y] == 'X' && board[1 + x][0 + y] == 'X' && board[2 + x][0 + y] == 'X') return 'X';
            else if( board[0 + x][0 + y] == 'O' && board[1 + x][0 + y] == 'O' && board[2 + x][0 + y] == 'O' ) return 'O';
            break;
        case 4:
             
            if(board[0 + x][1 + y] == 'X' && board[1 + x][1 + y] == 'X' && board[2 + x][1 + y] == 'X') return 'X';
            else if( board[0 + x][1 + y] == 'O' && board[1 + x][1 + y] == 'O' && board[2 + x][1 + y] == 'O' ) return 'O';
            break;
        case 5:
             
            if(board[0 + x][2 + y] == 'X' && board[1 + x][2 + y] == 'X' && board[2 + x][2 + y] == 'X') return 'X';
            else if( board[0 + x][2 + y] == 'O' && board[1 + x][2 + y] == 'O' && board[2 + x][2 + y] == 'O' ) return 'O';
            break;
        case 6:
            
            if(board[0 + x][0 + y] == 'X' && board[1 + x][1 + y] == 'X' && board[2 + x][2 + y] == 'X') return 'X';
            else if( board[0 + x][0 + y] == 'O' && board[1 + x][1 + y] == 'O' && board[2 + x][2 + y] == 'O' ) return 'O';
            break;
        case 7:
            
            if(board[0 + x][2 + y] == 'X' && board[1 + x][1 + y] == 'X' && board[2 + x][0 + y] == 'X') return 'X';
            else if( board[0 + x][2 + y] == 'O' && board[1 + x][1 + y] == 'O' && board[2 + x][0 + y] == 'O' ) return 'O';
            break;
        }
          
    }
    return 'w'; 
   }
    public boolean draw(char [][] board, int x, int y)
    {
        for(int i = 0; i < 3; i++)
         for(int j = 0; j < 3; j++)
          if(board[i + x][j + y] == ' ') return false;
        
        
        return true;  
    }

}

 

class NineCrossNine extends TicTacToebtwHumans
{
    char [][] gameboard = new char[9][9];

    public NineCrossNine(){
     
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                gameboard[i][j] = ' ';
            }  
           }
           
 }

    public void gameStart(){
        int i, j;
        boolean turn = true;
        char winner = 'w';
        while( winner == 'w' && !draw()){
            if(turn){
                System.out.println("Player 1's turn, Enter the coordinates");
                i = in.nextInt();
                j = in.nextInt();
                gameboard[i][j] = 'X';
            }
            else{
               System.out.println("Player 2's turn, Enter the coordinates");
               i = in.nextInt();
               j = in.nextInt();
               gameboard[i][j] = 'O';
            }
            displayBoard();
            turn = !turn;
            winner = win(gameboard);
            if(winner != 'w')
            System.out.println( winner + " is the winnner");
         }
    }

    public void displayBoard(){
        System.out.println("---------------------------------");
       for(int i =0; i < 9; i++){
           
            for(int j = 0; j < 9; j++){
                if(j == 8)
                System.out.println(gameboard[i][j] + " | ");
                else
                System.out.print(gameboard[i][j] + " | ");
                 
           }
           System.out.println("-----------------------------------");
       }
    }
    public char win(char[][] gameboard){
        
        if(super.win(gameboard, 0, 0) == 'X' && super.win(gameboard, 0, 3) == 'X' && super.win(gameboard, 0, 6) == 'X') return 'X';
        else if(super.win(gameboard, 0, 0) == 'O' && super.win(gameboard, 0, 3) == 'O' && super.win(gameboard, 0, 6) == 'O')return 'O';

        else if(super.win(gameboard, 3, 0) == 'X' && super.win(gameboard,3, 3) == 'X' && super.win(gameboard, 3, 6) == 'X') return 'X';
        else if(super.win(gameboard, 3, 0) == 'O' && super.win(gameboard, 3, 3) == 'O' && super.win(gameboard, 3, 6) == 'O')return 'O';  
        
        else if(super.win(gameboard,6 , 0) == 'X' && super.win(gameboard, 6, 3) == 'X' && super.win(gameboard, 6, 6) == 'X') return 'X';
        else if(super.win(gameboard, 6, 0) == 'O' && super.win(gameboard, 6, 3) == 'O' && super.win(gameboard, 6, 6) == 'O')return 'O';  

        else if(super.win(gameboard, 0, 0) == 'X' && super.win(gameboard, 3, 0) == 'X' && super.win(gameboard, 6, 0) == 'X') return 'X';
        else if(super.win(gameboard, 0, 0) == 'O' && super.win(gameboard, 3, 0) == 'O' && super.win(gameboard, 6, 0) == 'O')return 'O';  

        else if(super.win(gameboard, 0, 3) == 'X' && super.win(gameboard, 3, 3) == 'X' && super.win(gameboard, 6, 3) == 'X') return 'X';
        else if(super.win(gameboard, 0, 3) == 'O' && super.win(gameboard, 3, 3) == 'O' && super.win(gameboard, 6, 3) == 'O')return 'O';  

        else if(super.win(gameboard, 0, 6) == 'X' && super.win(gameboard, 3, 6) == 'X' && super.win(gameboard, 6, 6) == 'X') return 'X';
        else if(super.win(gameboard, 0, 6) == 'O' && super.win(gameboard, 3, 6) == 'O' && super.win(gameboard, 6, 6) == 'O')return 'O'; 
        
        else if(super.win(gameboard, 0, 0) == 'X' && super.win(gameboard, 3, 3) == 'X' && super.win(gameboard, 6, 6) == 'X') return 'X';
        else if(super.win(gameboard, 0, 0) == 'O' && super.win(gameboard, 3 ,3) == 'O' && super.win(gameboard, 6, 6) == 'O')return 'O'; 
        
        else if(super.win(gameboard, 0, 6) == 'X' && super.win(gameboard, 3, 3) == 'X' && super.win(gameboard, 6, 0) == 'X') return 'X';
        else if(super.win(gameboard, 0, 6) == 'O' && super.win(gameboard, 3, 3) == 'O' && super.win(gameboard, 6, 0) == 'O')return 'O';  

        else return 'w';
      
    }

    public boolean draw(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(super.draw(gameboard, 3*i, 3*j) == false) return false;
            }
        }
        return true;
    }

}

public class project
{
    public static void main(String args[]){
     System.out.println("Enter the board dimenstions");  
     Scanner in = new Scanner(System.in);
     int dimensions = in.nextInt();
     if(dimensions == 3){
         TicTacToebtwHumans t = new TicTacToebtwHumans();
         t.displayBoard();
         t.gameStart();
         }
     else if(dimensions == 9){
         
         NineCrossNine t = new NineCrossNine();
         t.displayBoard();
         t.gameStart();
     }
         
     }
}