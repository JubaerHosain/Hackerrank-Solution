import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        String answer  = "";
        Calendar ca = Calendar.getInstance();

        if(year < 1918 && year % 100 == 0){
            answer = getAnswer(ca, year, 255);
        }
        else if(year == 1918){
            answer = getAnswer(ca, year, 269);
        }
        else{
            answer = getAnswer(ca, year, 256);
        }

        return answer;
    }

    static String getAnswer(Calendar ca, int year, int day){
        ca.set(ca.YEAR, year);
        ca.set(ca.DAY_OF_YEAR, day);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        return sdf.format(ca.getTime());
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
