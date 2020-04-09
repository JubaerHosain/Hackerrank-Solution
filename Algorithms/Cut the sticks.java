import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cutTheSticks function below.
    static void cutTheSticks(int[] arr) {
        Arrays.sort(arr);

        System.out.println(arr.length);
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i-1]){
                System.out.println(arr.length - i);
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }

        scanner.close();

        cutTheSticks(arr);

    }
}
