import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char array[] = w.toCharArray();
        int length = array.length;

        int firstSmall = 0;
        for(firstSmall = length - 1; firstSmall > 0; firstSmall--){
            if(array[firstSmall] > array[firstSmall-1]){
                break;
            }
        }

        //firstSmall -= 1;               // index of firstSamll character
        if(firstSmall == 0){
            return "no answer";
        }
        else{
            firstSmall -= 1;
            int nextSmall = firstSmall + 1;
            for(int start = nextSmall + 1; start < length; start++){
                if(array[start] > array[firstSmall] && array[start] < array[nextSmall]){
                    nextSmall = start;
                }
            }

            //swap
            char temp = array[firstSmall];
            array[firstSmall] = array[nextSmall];
            array[nextSmall] = temp;

            Arrays.sort(array, firstSmall+1, length);
        }

        return new String(array);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
