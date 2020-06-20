import java.io.*;
import java.util.*;

public class Solution {
    static Scanner scan = new Scanner(System.in);

    static double getWeightedMean(int x[], int w[]){
        double a = 0, b = 0;
        
        for(int i = 0; i < x.length; i++){
            a += (x[i] * w[i]);
            b += w[i];
        }

        return a/b;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int  n = scan.nextInt();
        int[] x = new int[n], w = new int[n];

        for(int i = 0; i < n; i++){
            x[i] = scan.nextInt();
        }

        for(int i = 0; i < n; i++){
            w[i] = scan.nextInt();
        }

        System.out.printf("%.1f \n",getWeightedMean(x, w));
    }
}
