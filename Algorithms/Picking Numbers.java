import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int solve(int arr[]) {
    // Write your code here
        int counter[] = new int[101];
        for(int i : arr){
            counter[i]++;
        }

        int result = 0;
        for(int i = 0; i + 1 < counter.length; i++){
            result = Math.max(result, counter[i] + counter[i+1]);
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(Result.solve(a));

        sc.close();
    }
}
