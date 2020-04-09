import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridSearch function below.
    static String gridSearch(char[][] G, char[][] P) {
        boolean flag;
        int R = G.length, C = G[0].length;
        int r = P.length, c = P[0].length;

        for(int i = 0; i <= R-r; i++){
            for(int j = 0; j <= C-c; j++){
                flag = false;

                for(int k = 0; k < r; k++){
                    for(int l = 0; l < c; l++){
                        if(G[i+k][j+l] != P[k][l]){
                            flag = true;
                            break;
                        }
                    }
                    if(flag) break;
                }
                if(!flag) return "YES";
            }
        }
        
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            char[][] G = new char[R][C];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem.toCharArray();
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            char[][] P = new char[r][c];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem.toCharArray();
            }

            String result = gridSearch(G, P);

            System.out.println(result);
        }

        scanner.close();
    }
}
