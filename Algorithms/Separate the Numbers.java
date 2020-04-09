import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        if(s.charAt(0) == '0'){
            System.out.println("NO");
            return;
        }

        for(int length  = 1;  length <= s.length()/2; length++){
            long firstNumber = Long.parseLong(s.substring(0,length));
            String answer = "";

            long number = firstNumber;
            while(answer.length() < s.length()){
                answer += number;
                number++;
            }

            if(answer.equals(s)){
                System.out.println("YES " + firstNumber);
                return;
            }
        }

        System.out.println("NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
