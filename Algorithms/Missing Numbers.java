import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the missingNumbers function below.
    static void missingNumbers(int[] arr, int[] brr, int min) {
        int counter[] = new int[101];

        for(int i = 0; i < arr.length; i++){
            counter[arr[i] - min]++;
        }
        for(int i = 0; i < brr.length; i++){
            counter[brr[i] - min]--;
        }

        for(int i = 0; i < counter.length; i++){
            if(counter[i] != 0){
                System.out.print((i+min) + " ");
            }
        }
    }

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int min = Integer.MAX_VALUE;

        int n = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];

        for(int i = 0; i < m; i++){
            brr[i] = sc.nextInt();
            if(brr[i] < min){
                min = brr[i];
            }
        }
        
        missingNumbers(arr, brr, min);

        sc.close();
    }
}
