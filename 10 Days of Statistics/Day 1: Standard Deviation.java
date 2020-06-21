import java.io.*;
import java.util.*;

public class Solution {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scan.nextInt();
        int x[] = new int[n];

        long sum = 0;
        for(int i = 0; i < n; i++){
            x[i] = scan.nextInt();
            sum += x[i];
        }

        double mean = sum/(double)n;
        double bigSum = 0;
        for(int i = 0; i < n; i++){
            bigSum += Math.pow(x[i]-mean, 2);
        }

        System.out.printf("%.1f \n", Math.sqrt(bigSum/(double)n));
    }
}
