import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main extends TTT {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        Main game = new Main();
        char[][] board1 = new char[3][3];
        game.setBoard(board1);
        game.initializeBoard();
        Random generator = new Random();
        int x = generator.nextInt(2) + 1;
        for(int i = 0; i < x; x++){ game.changePlayer();}
        System.out.println("Tic-Tac-Toa");
        do {
            System.out.println("Current board layout");
            game.printBoard();
            int row;
            int col;
            do {
                System.out.println("Player " + game.getCurrentPlayerMark() + " - enter empty row and col");
                row = scan.nextInt() - 1;
                col = scan.nextInt() - 1;
            }
            while (!game.placeMark(row, col));
            game.changePlayer();
        }
        while (game.isBoardFull() && !game.checkForWin());

        System.out.println(game.isBoardFull());
        System.out.println(game.checkForWin());

        if (game.checkForWin()){
            System.out.println("Current board layout");
            game.printBoard();
            game.changePlayer();
            System.out.println("The winner is Player " + game.getCurrentPlayerMark() + "!");
        } else {
            System.out.println("Current board layout");
            game.printBoard();
            game.changePlayer();
            System.out.println("TIE");
        }
    }
}