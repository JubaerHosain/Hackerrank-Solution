import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;


public class Solution {
    private static int getTotal(int set1[], int set2[], int max1, int min2){
        int counter  = 0;

        for(int i = max1; i <= min2; i++){
            boolean isCount = false;

            for(int j = 0; j < set1.length; j++){
                if(i % set1[j] != 0){
                    isCount = true;
                    break;
                }
            }

            for(int j = 0; j < set2.length; j++){
                if(set2[j] % i != 0){
                    isCount = true;
                    break;
                }
            }

            if(!isCount){
                counter++;
            }
        }

        return counter;
    }


    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int max1 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        int set1[] = new int[m];
        int set2[] = new int[n];

        for(int i = 0; i < m; i++){
            set1[i] = scan.nextInt();
            max1 = Math.max(max1, set1[i]);
        }

        for(int i = 0; i < n; i++){
            set2[i] = scan.nextInt();
            min2 = Math.min(min2, set2[i]);
        }

        System.out.println(getTotal(set1, set2, max1, min2));

    }
}
