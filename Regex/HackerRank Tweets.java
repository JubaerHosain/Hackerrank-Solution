import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        Pattern p = Pattern.compile("hackerrank", Pattern.CASE_INSENSITIVE);
        int count = 0;
        while(n-- > 0){
            String input = scan.nextLine();
            Matcher m = p.matcher(input);

            while(m.find()){
                count++;
            }
        }

        System.out.println(count);
    }
}
