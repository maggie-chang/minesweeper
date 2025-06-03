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

            System.out.print("Exter the x-coodinate you want to check: ");
            int x = scanner.nextInt();

            System.out.print("Exter the y-coodinate you want to check: ");
            int y = scanner.nextInt();

            System.out.print("(f)lag or (b)break (" + x + "," + y + ")?: ");
            String fOrB = scanner.nextLine();

            if (fOrB.equals("b")) {
                //board[x][y].setIsUncovered();
                int squareVal = board.checkCoordinates(x, y);

                if (squareVal == board.BOMB_VAL) {
                    System.out.println("You lost!");
                }
            }
            else if (fOrB.equals("f")) {

            }
            else {
                System.out.println("you are bad");
            }

            bombCount++;
            break;
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