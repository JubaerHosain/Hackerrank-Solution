import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the counterGame function below.
    static String counterGame(long n) {
        if(n == 1){
            return "Richard";
        }

        boolean first = true;
        while(n != 1){
            if(first){
                if((n & n-1) == 0){
                    n = n >> 1; 
                }
                else{
                    n = n - prevPowOf2(n);
                }
                first  = false;
            }
            else{
                if((n & n-1) == 0){
                    n = n >> 1; 
                }
                else{
                    n = n - prevPowOf2(n);
                }
                first  = true;
            }
        }

        return first? "Richard":"Louise" ;
    }

    static long prevPowOf2(long n){
        while((n & n-1) != 0){
            n = n & n-1;
        }

        return n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = counterGame(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
