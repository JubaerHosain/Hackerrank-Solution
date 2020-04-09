import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cavityMap function below.
    static char[][] cavityMap(char grid[][], int n) {

        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < n-1; j++){
                if(grid[i][j] > grid[i-1][j] && grid[i][j] > grid[i][j-1] && 
                grid[i][j] > grid[i+1][j] && grid[i][j] >  grid[i][j+1]){
                    grid[i][j] = 'X';
                }
            }
        }

        return grid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char grid[][] = new char[101][101];

        for(int i = 0; i < n; i++){
            String input = sc.next();
            for(int j = 0; j < n; j++){
                grid[i][j] = input.charAt(j);
            }
        }

        grid = cavityMap(grid, n);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        
    }
}
