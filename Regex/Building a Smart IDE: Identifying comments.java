import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(scan.hasNextLine()){
            sb.append(scan.nextLine().trim());
            sb.append("\n");
        }

        Pattern p = Pattern.compile("(\\/)(\\*)(.|\\s)*?\\2\\1|(\\/\\/.*)");
        Matcher m = p.matcher(sb.toString());

        while(m.find()){
            System.out.println(m.group());
        }
        scan.close();
    }
}
