import java.util.*;

class GameDesign 
{
    Scanner in = new Scanner(System.in);
    char [][] hexBoard;
    int height, width, inputCoordinate1, inputCoordinate2, boarddim;
    public GameDesign(int boarddim){
        this.boarddim = boarddim;
        height = 2*boarddim - 1;
        width = 2*height - 1;
        hexBoard =  new char[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                hexBoard[i][j] = '*';
            }
        }
        int x = boarddim - 1, y = boarddim;
        for(int i = 0; i < height; i++){
            for(int j = x; j < (x + y*2 - 1); j += 2){
              hexBoard[i][j] = '8';
            }
            if(i < (boarddim - 1)){ x--; y++;}
            else { x++; y--; }
        }
    }
    public void printBoard()
    {
        System.out.println();
        for(int i = 0; i < height; i++){
            System.out.print(i + "| "); 
            for(int j = 0; j < width; j++){
                 
                System.out.print(hexBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void gameStart()
    {
        System.out.println("You have to enter the co-ordinates based on zero-indexing by seeing the board displayed. Positions with 8 are valid inputs");
        boolean turn = true;
        char winner = 'w', player;
        while(winner == 'w'){
            if(turn) player = 'X';
            else 
            player = 'O';
            System.out.println("Player " + player + " enter your co-ordinates");
            inputCoordinate1 = in.nextInt();
            inputCoordinate2 = in.nextInt();

           if(hexBoard[inputCoordinate1][inputCoordinate2] == '*')
             System.out.println("You have enter the wrong co-odinates please enter the co-ordinates which are empty(Shown with 8)");
           else if(hexBoard[inputCoordinate1][inputCoordinate2] == 'X' || hexBoard[inputCoordinate1][inputCoordinate2] == 'O')
             System.out.println("The co-ordinates you have entered are already filled. Please enter the co-ordinates which are empty(Shown with 8");
           else{
              if(turn){
               System.out.println("Enter player 'X' co-ordinates");
               hexBoard[inputCoordinate1][inputCoordinate2] = 'X';
               winner = checkWin('X', inputCoordinate1, inputCoordinate2);
              } 
              else if(!turn){
               System.out.println("Enter player 'O' co-ordinates");   
               hexBoard[inputCoordinate1][inputCoordinate2] = 'O';
               winner = checkWin('O', inputCoordinate1, inputCoordinate2);
              }
              turn = !turn;
              printBoard();
              if(winner != 'w') System.out.println("Player " + winner + " is the winner");
           }
        }
    }
    public char checkWin(char winning_variable, int inputCoordinate1, int inputCoordinate2)
    {
       int count = 0; 
       int x = inputCoordinate1;
       int y = inputCoordinate2;
       while(coordinatesInrange(x, y)){
           if(hexBoard[x][y] == winning_variable){
               count++;
               x--;
               y++;
           }
       }
       x = inputCoordinate1;
       y = inputCoordinate2;
       while(coordinatesInrange(x, y)){
           if(hexBoard[x][y] == winning_variable){
               count++;
               x--;
               y--;
           }
       }
       if(count > boarddim) return winning_variable;
       count = 0;
       x = inputCoordinate1;
       y = inputCoordinate2;
       while(coordinatesInrange(x, y)){
        if(hexBoard[x][y] == winning_variable){
            count++;
            x++;
            y++;
        }
       }
       x = inputCoordinate1;
       y = inputCoordinate2;
       while(coordinatesInrange(x, y)){
        if(hexBoard[x][y] == winning_variable){
            count++;
            x++;
            y--;
        }
       }
       if(count > boarddim) return winning_variable;
       x = inputCoordinate1;
       y = inputCoordinate2;
       count = 0;
       while(coordinatesInrange(x, y)){
        if(hexBoard[x][y] == winning_variable){
            count++;
            y += 2;
        }
       }
       x = inputCoordinate1;
       y = inputCoordinate2;
       while(coordinatesInrange(x, y)){
        if(hexBoard[x][y] == winning_variable){
            count++;
            y -= 2;
        }
       }
       if(count > boarddim) return winning_variable;
       return 'w';
    }

    public boolean coordinatesInrange(int x, int y)
    {
        if(x >= 0 && x < height && y >= 0 && y < width && hexBoard[x][y] != '8' && hexBoard[x][y] != '*') return true;
        return false;
    }
    
}

public class SuperTicTacToe 
{
    public static void main(String args[]){
        System.out.println("Enter the board Dimensions");
        Scanner in = new Scanner(System.in);
        int boarddim = in.nextInt();
        GameDesign play = new GameDesign(boarddim);
        play.printBoard();
        play.gameStart();
    }
}
