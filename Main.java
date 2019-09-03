package Board;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int size = 0;
        Scanner input = new Scanner(System.in);
        while (size > 10 || size < 1) {
            System.out.println("Enter a size n between 1 and 10: ");
            size = input.nextInt();
        }
        size = (int) Math.pow(2, size);
        int col =-1;
        int row =-1;
        while(row > size-1 || row < 0) {
            System.out.println("Choose a random row value between 0 and " + (size - 1));
            row = input.nextInt();
        }
        while(col > size-1 || col < 0) {
            System.out.println("Choose a random column value between 0 and " + (size - 1));
            col = input.nextInt();
        }

        Board board = new Board(size, col, row);

        System.out.println("size: " + size);
        board.solveBoard();
        System.out.print("FINAL ");
        board.printArray();
    }
}
