import java.util.ArrayList;

public class Board {

    private int num = (int) Math.random()*1 + 4;
    private Square[][] board = new Square[3][5];

    public final int flagNum = 5;
    public final int NUM_BOMB = 5;
    public final int BOMB_VAL = -1;

    public Board() {
        fillBoard();
    }


    // initializes each square on the board and returns the filled board
    public Square[][] fillBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = new Square(0, false);
            }
        }

        //randomizes bomb placement
        for (int i = 0; i < NUM_BOMB; i++){
            int rx = (int)(Math.random() * board.length);
            int ry = (int)(Math.random() * board[0].length);
            board[rx][ry] = new Square(BOMB_VAL, false);
        }

        /* ensures not indexoutofbounds and checks if bomb
          increments num (Square class) if square is not -1 (bomb)
        */
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

        for (int k = 0; k <= board[0].length-1; k++) { 
            if (k == 0) {
                System.out.print("    ");
            }
            System.out.print(k + "  ");
        }
        System.out.println();
        for (int f = 0; f <= board[0].length; f++) {
            System.out.print("---");
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < board[0].length; j++) {
                //System.out.print(j);
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
            System.out.println();
        }
    }

    // checks if its a bomb, bomb indicator (pos num), or no number
    // returns -1 if bomb, 0 if no num, -2 if bomb indicator
    public int checkCoordinates(int y, int x) {
        Square currSquare = board[y][x];
        if (currSquare.isBomb() ) { //bomb condition;
            //&& currSquare.getIsUncovered() // something about this and the ! makes it so the 
            //"x" shows up, but it messes up other things. :()
            return BOMB_VAL;
        }
        if (currSquare.getNumVal() == 0) { // no number
            return 0;
        }
        return -2;
    }


    public Square[][] getBoard() {
        return board;
    }

}
