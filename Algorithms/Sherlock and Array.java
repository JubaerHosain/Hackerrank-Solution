import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the balancedSums function below.
    static String balancedSums(int arr[]) {

        int sum = 0;
        int S[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            S[i] = sum;
        }

        sum = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            sum += arr[i];
            S[i] -= sum;
        }

        return Arrays.binarySearch(S, 0) < 0 ? "NO" : "YES";

    }

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int testCase = sc.nextInt();

        for(int t = 1; t <= testCase; t++){
            int n = sc.nextInt();
            int arr[] = new int[n];

            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            String result = balancedSums(arr);

            System.out.println(result);
        }

        sc.close();
    }
}
