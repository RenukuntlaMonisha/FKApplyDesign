import java.util.*;

class gameBoard {
    int [][] board;
    int row;
    int column;
    gameBoard(int size) {
        this.row = size;
        this.column = size;
        board = new int[size][size];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = 0;
            }
        }
    }
    boolean isValid(int row,int column,int size){
        if((row>=0 && row<size) && (column>=0 && column<size)){
            return true;
        }
        return false;
    }
    boolean isOccupied(int row,int column){
        if(board[row][column]==0) return false;
        return true;
    }
    void userInput(int row,int column,int value){
        board[row][column]=value;
    }
    void display(int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    int winwin3_3(int size,int row,int column,int [][] board){
        for(int i=0;i<size;i++){
            if((board[row+i][column+0]!=0) && ((board[row+i][column+0]==board[row+i][column+1]) && (board[row+i][column+1]==board[row+i][column+2])))
            {
                if(board[row+i][column+0]==1){
                    return 1;
                }
                else{
                    return 2;
                }
            }
        }
        for(int i=0;i<size;i++){
            if((board[row+0][column+i]!=0) && ((board[row+0][column+i]==board[row+1][column+i]) && (board[row+1][column+i]==board[row+2][column+i])))
            {
                if(board[row+0][column+i]==1)
                    return 1;
                else
                    return 2;
            }
        }
        if ( board[row+0][column+0]!=0 && (board[row+0][column+0] == board[row+1][column+1] && board[row+1][column+1] == board[row+2][column+2]) ) {
            if(board[row+0][column+0]==1) return 1;
            return 2;
        }
        if ( board[row+0][column+2]!=0 && (board[row+0][column+2] == board[row+1][column+1] && board[row+1][column+1] == board[row+2][column+0]) ) {
            if(board[row+0][column+2]==1) return 1;
            return 2;
        }
        return 0;
    }
    int winwin(int size,int row,int column,int div){
        if(size==3){
            return winwin3_3(size,row,column,board);
        }
        else{
            int [][] temporary=new int[3][3];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    temporary[i][j]=0;
                }
            }
            int inc=size/div;
            temporary[0][0]=winwin(inc,row,column,div);
            temporary[0][1]=winwin(inc,row,column+inc,div);
            temporary[0][2]=winwin(inc,row,column+2*inc,div);
            temporary[1][0]=winwin(inc,row+inc,column,div);
            temporary[1][1]=winwin(inc,row+inc,column+inc,div);
            temporary[1][2]=winwin(inc,row+inc,column+2*inc,div);
            temporary[2][0]=winwin(inc,row,column,div);
            temporary[2][1]=winwin(inc,row+2*inc,column+inc,div);
            temporary[2][2]=winwin(inc,row+2*inc,column+2*inc,div);


            return winwin3_3(3,0,0,temporary);
        }
    }

}
class Player{
    private static int id=1;
    int isComputer ;
    int user;
    int iswinner;
    Player(){
        this.user=id;
        id++;
        this.iswinner=0;
    }
    void checkIfComputer(int computer){
        this.isComputer=computer;
    }
}
class TicTacToe{
    Scanner in=new Scanner(System.in);
    Random r=new Random();
    gameBoard board;
    int total_filled=0;
    int size;
    TicTacToe(int size){
        this.size=size;
        board=new gameBoard(size);
    }
    boolean isOver(Player p1,Player p2){
        int result=board.winwin(size,0,0,3);
        if(result==1){
            p1.iswinner=1;
            return true;
        }
        if(result==2){
            p2.iswinner=1;
            return true;
        }
        return false;
    }
    void move(Player p){
        int row;
        int column;
        if(p.isComputer==1){
            row = r.nextInt(size);
            column = r.nextInt(size);
            while(!board.isOccupied(row,column)){
                row = r.nextInt(size);
                column = r.nextInt(size);
            }
        }
        else{
            row=in.nextInt();
            column=in.nextInt();
            while(!board.isValid(row,column,size)){
                System.out.println("Your input is out of Range, enter again");
                row=in.nextInt();
                column=in.nextInt();
            }
            while(board.isOccupied(row,column)){
                System.out.println("Your input position is filled, enter again");
                row=in.nextInt();
                column=in.nextInt();
            }
        }
        board.userInput(row,column,p.user);
        total_filled++;
        board.display(size);
    }
}
public class project{
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("Press '1' to play Game between humans");
        System.out.println("press '2' to play Game between Human and computer");

        int type=in.nextInt();
        Player p1=new Player();
        Player p2=new Player();
        if(type==1){
            p1.checkIfComputer(0);
            p2.checkIfComputer(0);
        }
        if(type==2){
            p1.checkIfComputer(0);
            p2.checkIfComputer(1);
        }
        System.out.println("Enter the board Dimensions that you want to play");
        int size=in.nextInt();
        TicTacToe game=new TicTacToe(size);
        int move=1;
        while(!game.isOver(p1,p2) && game.total_filled!=size*size){
            if(move==1){
                System.out.println("Player 1 move");
                game.move(p1);
                move=2;
            }
            else{
                System.out.println("Player 2 move");
                game.move(p2);
                move=1;
            }
        }
        if(p1.iswinner==1){
            System.out.println("Player 1 is a winner");
        }
        else if(p2.iswinner==1){
            System.out.println("Player 2 is a winner");
        }
        else{
            System.out.println("Match drawn");
        }
    }
}