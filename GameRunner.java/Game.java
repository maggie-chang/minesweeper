//import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Board board = new Board();
    Square[][] sqrBoard = board.getBoard();
    

    public Game() {
        //play();
    }

    public void printIntro() {
        System.out.println("");
        System.out.println("~~~");
        System.out.println("Welcome to Minesweeper! Use coordinates (x-coord: row; y-coord: col)");
        System.out.println("to (b)reak, (f)lag, or (u)nflag squares!");
        System.out.println("~~~");

    }

    public void runBoard() {

        int flaggedBombCount = 0;
        int flagCount = board.flagNum;

        System.out.println("You have " + flagCount + " flags to place on all the bombs.");
        System.out.println("");

        while (flaggedBombCount < board.NUM_BOMB) {

            board.printBoard();
            
            System.out.print("x-coord: "); // like on a graph; x is col
            int x = Integer.parseInt(scanner.nextLine());
            System.out.print("y-coord: "); // y is row
            int y = Integer.parseInt(scanner.nextLine());

            if ((y > sqrBoard.length-1) || (x > sqrBoard[0].length-1) || y < 0 || x < 0) {
                System.out.println("Please enter coordinates within the board size.");
            }

            else {

                System.out.print("(b)reak, (f)lag, or (u)nflag at (" + x + "," + y + ")?: ");
                String bFU = scanner.nextLine();
                System.out.println();

                int squareVal = board.checkCoordinates(y, x);

                if (bFU.equals("b")) {
                
                    if (squareVal == board.BOMB_VAL) {
                        board.getBoard()[y][x].setIsUncovered();
                        board.printBoard();
                        System.out.println("You hit a bomb!");
                        System.out.println("");
                        break;
                    }
                    else {
                        board.getBoard()[y][x].setIsUncovered(); //defo need
                    }
                }

                else if (bFU.equals("f")) {
                    board.getBoard()[y][x].getFlag();
                    board.getBoard()[y][x].setFlag(true);
                    flagCount--;
                    System.out.println("Flags: " + flagCount);
                    System.out.println("");

                    if (board.getBoard()[y][x].isBomb()) {
                        flaggedBombCount++;
                    }
                }

                else if (bFU.equals("u")) {
                    board.getBoard()[y][x].setFlag(false);
                    flagCount++;
                    System.out.println("Flags: " + flagCount);
                    System.out.println("");

                }

                if (flaggedBombCount == board.NUM_BOMB) {
                    System.out.println("You win! Thanks for flagging all the bombs :)");
                    System.out.println("");
                    break;
                }
            }
        }

    }

    public void play() {
        printIntro();
        runBoard();    
    } 
}