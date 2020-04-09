import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        if(s.length() + t.length() <= k){
            return "Yes";
        }

        int i = 0;
        for(; i<s.length() && i<t.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                break;
            }
        }

        int minOperation = (s.length() - i) + (t.length() - i);

        if(k>=minOperation && (k-minOperation)%2==0){
            return "Yes";
        }
        else{
            return "No";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
