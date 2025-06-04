//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Board board = new Board();

    
    public Game() {
        int bombCount = 0;
        while (bombCount < board.NUM_BOMB) {
            board.printBoard();

            System.out.print("x-coord: ");
            int x = scanner.nextInt();

            System.out.print("y-coord: ");
            int y = scanner.nextInt();
            scanner.nextLine(); // not questioning this and not i pray to stackOverflow users daily

            System.out.print("(f)lag or (b)break (" + x + "," + y + ")?: ");
            String fOrB = scanner.nextLine();

            System.out.println("TEST");
            if (fOrB.equals("b")) {
                //board[x][y].setIsUncovered();
                int squareVal = board.checkCoordinates(x, y);
                System.out.println("TEST");

                if (squareVal == board.BOMB_VAL) {
                    System.out.println("You lost!");
                }
            }
            else if (fOrB.equals("f")) {
                System.out.println("TEST");

            }
            /* 
            else {
                System.out.println("you are bad");
            }

            bombCount++;
            //break; */
        }
    }

    public void printIntro() {

    }

    public void runBoard() {
    }
  

    public void play() {
        printIntro();
        runBoard();
        
    } 
}