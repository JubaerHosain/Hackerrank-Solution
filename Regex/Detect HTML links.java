import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern p = Pattern.compile("<a\\shref=\"([^\"]+)\"([^<>]*)>(<\\w>)*([^<>]*)<");

        int n = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < n; i++){
            String input = scan.nextLine();
            Matcher m = p.matcher(input);

            while(m.find()){
                System.out.println(m.group(1).trim()+","+m.group(4).trim());
            }
        }
    }
}
