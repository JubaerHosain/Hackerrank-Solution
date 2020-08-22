import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        String latitude = "[+-]?(90(\\.0+)?|[1-8]\\d(\\.\\d+)?|\\d(\\.\\d+)?)";
        String longtitute = "[+-]?(180(\\.0+)?|1[0-7]\\d(\\.\\d+)?|[1-9]\\d(\\.\\d+)?|\\d(\\.\\d+)?)";

        Pattern p = Pattern.compile("^\\("+latitude + ",\\s" + longtitute + "\\)$");

        while(n-- > 0){
            String input = scan.nextLine();
            Matcher m = p.matcher(input);

            if(m.matches()){
                System.out.println("Valid");
            }
            else{
                System.out.println("Invalid");
            }
        }   

        scan.close();
    }
}
