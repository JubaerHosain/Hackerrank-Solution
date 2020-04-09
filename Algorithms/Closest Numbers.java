import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the closestNumbers function below.
    static void closestNumbers(int[] arr) {
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder("");
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - 1; i++){
            int dis = Math.abs(arr[i] - arr[i+1]);
            if(dis < min){
                min = dis;
                sb = new StringBuilder("");
                sb.append(arr[i] + " "+ arr[i+1] + " ");
            }
            else if(min == dis){
                sb.append(arr[i] + " "+ arr[i+1] + " ");
            }
        }

        System.out.println(sb.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++)
            array[i] = input.nextInt();

        closestNumbers(array);            
    }
}
