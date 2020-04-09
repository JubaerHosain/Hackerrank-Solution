import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static boolean checkColumns(char[][] grid){
        for(int i = 0; i < grid.length; i++){//column
            for(int j = 1; j < grid.length; j++){//row
                if(grid[j][i] < grid[j-1][i])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        StringBuilder  output = new StringBuilder("");
        for(int t = 0; t < T; t++){
            
            int n = input.nextInt();input.nextLine();
            char[][] grid = new char[n][n];
            
            //Read in rows of grid and sort
            for(int i = 0; i < n; i++){
                grid[i] = input.nextLine().toCharArray();
                Arrays.sort(grid[i]);
            }
            
            if(checkColumns(grid))
                output.append("YES\n");
            else
                output.append("NO\n");
            
        } 
        System.out.print(output);
    }
}
