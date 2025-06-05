//import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Board board = new Board();
    Square[][] sqrBoard = board.getBoard();
    

    public Game() {

        int bombCount = 0;
        while (bombCount < board.NUM_BOMB) {
            board.printBoard();
            
            System.out.print("x-coord: ");
            int x = scanner.nextInt(); // like on a graph; x is col

            System.out.print("y-coord: "); // y is row
            int y = scanner.nextInt();
            scanner.nextLine(); // not questioning this and not i pray to stackOverflow users daily

            if ((y > sqrBoard.length-1) || (x > sqrBoard[0].length-1)) {
                System.out.println("Please enter coordinates within the board size.");
            }
            else {
                System.out.print("(b)reak, (f)lag, or (u)nflag at (" + x + "," + y + ")?: ");
                String bFU = scanner.nextLine();
                System.out.println();

                if (bFU.equals("b")) {
                    board.getBoard()[y][x].setIsUncovered();
                    int squareVal = board.checkCoordinates(y, x);

                    if (squareVal == board.BOMB_VAL) { // **NEED TO REVISE, DOES NOT SHOW BOMB WHEN LOSE
                        //board.getBoard()[y][x].getIsUncovered();
                        System.out.println("You lost!");
                        break;
                    }
                    board.getBoard()[y][x].getIsUncovered();
                }
                else if (bFU.equals("f")) {
                    board.getBoard()[y][x].getFlag();
                    board.getBoard()[y][x].setFlag(true);
                }
                else if (bFU.equals("u")) {
                    board.getBoard()[y][x].setFlag(false);
                }
                else {
                    System.out.println("you are bad");
                }

                bombCount++;
                //break; */
            }
        }
    }

    public void printIntro() {
        System.out.print("");
    }

    public void runBoard() {
        
    }
  

    public void play() {
        printIntro();
        runBoard();
        
    } 
}