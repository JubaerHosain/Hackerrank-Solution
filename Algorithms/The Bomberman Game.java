import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bomberMan function below.
    static char[][] bomberMan(int n, char[][] grid) {

        if(n == 1){
            return grid;
        }

        char even[][] = new char[grid.length][grid[0].length];
        char first[][] = new char[grid.length][grid[0].length];
        char second[][] = new char[grid.length][grid[0].length];
        char third[][] = new char[grid.length][grid[0].length];
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                even[i][j] = 'O';
                first[i][j] = 'O';
                second[i][j] = 'O';
                third[i][j] = 'O';
            }
        }

        first = newGrid(grid, first);

        if(n % 2 == 0){
            return even;
        }
        else if(n == 3){
            return first;
        }
        else{
            second = newGrid(first, second);
            third = newGrid(second, third);

            if(n % 4 == 1){
                return second;
            }
            else{
                return third;
            }
        }

    }

    static char[][] newGrid(char[][] previous, char[][] next){
        for(int i = 0; i < next.length; i++){
            for(int j = 0; j < next[0].length; j++){

                char bomb = previous[i][j];
                if(bomb == 'O'){
                    next[i][j] = '.';

                    if (i - 1 >= 0) {
                        next[i - 1][j] = '.';
                    }
                    if (i + 1 <= next.length - 1) {
                        next[i + 1][j] = '.';
                    }
                    if (j - 1 >= 0) {
                        next[i][j - 1] = '.';
                    }
                    if (j + 1 <= next[0].length - 1) {
                        next[i][j + 1] = '.';
                    }
                }
            }
        }

        return next;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        char[][] grid = new char[r][c];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem.toCharArray();
        }

        char[][] result = bomberMan(n, grid);

        for (int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++){
                bufferedWriter.write(result[i][j]);
            }
            bufferedWriter.write("\n");
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
