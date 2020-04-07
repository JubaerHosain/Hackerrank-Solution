import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String parts[] = s.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2].substring(0, 2));
        String AMPM = parts[2].substring(2, 4);

        String time = "";
        if(AMPM.compareTo("PM") == 0){
            time = String.format("%02d:%02d:%02d", hours + 12, minutes, seconds);
            if(hours == 12)
                time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }
        else{
            time = String.format("%02d:%02d:%02d", 12 - hours, minutes, seconds);
            if(hours < 12)
                time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }
        
        return time;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
