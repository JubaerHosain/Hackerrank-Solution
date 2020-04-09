import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        int count = 4;

        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;

        for(char ch: password.toCharArray()){
            if(numbers.indexOf(ch) != -1 && hasDigit == false){
                hasDigit = true;
                count--;
            }
            if(lower_case.indexOf(ch) != -1 && hasLower == false){
                hasLower = true;
                count--;
            }
            if(upper_case.indexOf(ch) != -1 && hasUpper == false){
                hasUpper = true;
                count--;
            }
            if(special_characters.indexOf(ch) != -1 && hasSpecial == false){
                hasSpecial = true;
                count--;
            }
        }

        return Math.max(count, 6 - password.length());

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
