import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        int row = (int)Math.floor(Math.sqrt(s.length()));
        int colum = (int)Math.ceil(Math.sqrt(s.length()));
        

        char array[] = s.toCharArray();
        String result = "";

        for(int i = 0; i < colum; i++){
            for(int j = i; j < s.length(); j+=colum){
                result += array[j];
            }
            result += " ";
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
