import java.util.ArrayList;

public class Board {

    private int num = (int) Math.random()*1 + 4;
    private Square[][] board = new Square[10][10];
    private final int flagNum = 10;
    private final int NUM_BOMB = 15;
    private final int BOMB_VAL = -1;

    public Board() {
        fillBoard();
    }

    private int randomizeBomb() {
        return num;
    }

    public Square[][] fillBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Square(0, false);
            }
        }

        for (int i = 0; i < NUM_BOMB; i++){
            int rx = (int)(Math.random() * board.length);
            int ry = (int)(Math.random() * board[0].length);
            board[rx][ry] = new Square(BOMB_VAL, false);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].isBomb()) {
                    if (i-1 >= 0 && !board[i-1][j].isBomb()) { 
                        board[i-1][j].addNumVal(1); //add 1 up of bomb
                    }
                    if (i+1 < board.length && !board[i+1][j].isBomb()) { 
                        board[i+1][j].addNumVal(1); //add 1 down up of bomb
                    }
                    if (j-1 >= 0 && !board[i][j-1].isBomb()) { 
                        board[i][j-1].addNumVal(1); //add 1 left of bomb
                    }
                    if (j+1 < board.length && !board[i][j+1].isBomb()) { 
                        board[i][j+1].addNumVal(1); //add 1 right of bomb
                    }
                    if (i+1 < board.length && j+1 < board.length && !board[i+1][j+1].isBomb()) {
                        board[i+1][j+1].addNumVal(1); //add 1 right & down of bomb
                    }
                    if (i-1 >= 0 && j+1 < board.length && !board[i-1][j+1].isBomb()) {
                        board[i-1][j+1].addNumVal(1); //add 1 right & up of bomb
                    }
                    if (i-1 >= 0 && j-1 >= 0 && !board[i-1][j-1].isBomb()) {
                        board[i-1][j-1].addNumVal(1); //add 1 left & up of bomb
                    }
                    if (i+1 < board.length && j-1 >= 0 && !board[i+1][j-1].isBomb()) {
                        board[i+1][j-1].addNumVal(1); //add 1 left & down of bomb
                    }
                }
            }
        }

        return board;

    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }
    }

}
