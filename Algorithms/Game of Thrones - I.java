import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        int counter[] = new int[26];

        for(int i = 0; i < s.length(); i++){
            counter[s.charAt(i) - 'a']++;
        }

        int ans = 0;

        for(int i = 0; i < 26; i++){
            if(counter[i] % 2 != 0){
                ans++;
            }
        }

        if(ans == 1 || ans == 0){
            return "YES";
        }
        else{
            return "NO";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
