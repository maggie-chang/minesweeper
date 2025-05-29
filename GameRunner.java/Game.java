//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Board board = new Board();

    
    public Game() {
        board.printBoard();
    }

    public void printIntro() {

    }

    public void runBoard() {
        
    }

    public void arrayTest() {
        String[][] arr = new String[4][6];
        int n = (int) Math.random()*1 + 4;


        for (int i = 0; i < arr.length; i++) {
            for (int h = 0; h < arr[0].length; h++) {

            }
        }
    }
  

    public void play() {
        printIntro();
        runBoard();
        
    } 
}