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

public class Solution {

    // Complete the birthday function below.
    static int birthday(int squres[], int d, int m) {
        int result = 0;

        for(int i = 0; i <= squres.length - m; i++){
            int sum = 0;

            for(int k = 0, j = i; k < m; k++, j++){
                if(j > squres.length - 1){
                    break;
                }
                sum += squres[j];
            }

            if(sum == d){
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int squres[] = new int[n];

        for(int i = 0; i < n; i++){
            squres[i] = scan.nextInt();
        }

        int d = scan.nextInt();
        int m = scan.nextInt();

        int result = birthday(squres, d, m);
        System.out.println(result);
    }
}
