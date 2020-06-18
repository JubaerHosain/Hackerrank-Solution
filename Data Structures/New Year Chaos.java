import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] a){
        int bribe = 0; 

        for(int i = a.length-1; i >=1; i--){
            if(a[i] != i){
                if(a[i-1] == i){
                    bribe += 1;
                    swap(a, i-1, i);
                }
                else if(a[i-2] == i){
                    bribe += 2;
                    swap(a, i-2, i-1);
                    swap(a, i-1, i);
                }
                else{
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }

        System.out.println(bribe);
    }

    static void swap(int a[], int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] a = new int[n+1];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 1; i <= n; i++) {
                int qItem = Integer.parseInt(qItems[i-1]);
                a[i] = qItem;
            }

            minimumBribes(a);
        }

        scanner.close();
    }
}
