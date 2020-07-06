import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(Integer[] sticks) {
        int result[] = new int[3];
        int max = Integer.MIN_VALUE;

        Arrays.sort(sticks, Collections.reverseOrder());

        for(int i = 0; i < sticks.length - 2; i++){
            if((sticks[i] < sticks[i+1] + sticks[i+2]) && (max < sticks[i]+sticks[i+1]+sticks[i+2])){
                max = sticks[i]+sticks[i+1]+sticks[i+2];
                result[0] = sticks[i+2];
                result[1] = sticks[i+1];
                result[2] = sticks[i];
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Integer[] sticks = new Integer[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            Integer sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        int[] result = maximumPerimeterTriangle(sticks);

        if(Arrays.binarySearch(result, 0) > 0){
            bufferedWriter.write(String.valueOf(-1));
        }
        else{
            for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
