import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the anagram function below.
    static int anagram(String s) {
        if(s.length()%2 != 0){
            return -1;
        }
        
        char strArray[] = s.toCharArray();

        return getResult(strArray);
    }

    static int getResult(char strArray[]){
        int counter1[] = new int[26];
        int counter2[] = new int[26];

        for(int i = 0; i < strArray.length; i++){
            if(i < strArray.length/2){
                counter1[strArray[i] - 'a']++;
            }
            else{
                counter2[strArray[i] - 'a']++;
            }
        }

        int result = 0;
        for(int i = 0; i < 26; i++){
            result += Math.abs(counter1[i] - counter2[i]);
        }

        return result/2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
