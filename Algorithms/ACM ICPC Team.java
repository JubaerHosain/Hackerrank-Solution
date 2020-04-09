import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int maxTopic = 0;
        int maxTeam = 0;
        int counter = 0;

        for(int i = 0; i < topic.length; i++){
            for(int j = i + 1; j < topic.length; j++){
                counter = 0;
                for(int k =0; k < topic[0].length(); k++){
                    if(topic[i].charAt(k) == '1' || topic[j].charAt(k) == '1'){
                        counter++;
                    }
                }
                if(maxTopic == counter){
                    maxTeam++;
                }
                if(maxTopic < counter){
                    maxTopic = counter;
                    maxTeam = 1;
                }
            }
        }

        int result[] = new int[2];
        result[0] = maxTopic;
        result[1] = maxTeam;

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
