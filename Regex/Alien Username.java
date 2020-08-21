import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    static Pattern p = Pattern.compile("^[_.][0-9]+[a-zA-Z]*[_]?$");
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        while(n-- > 0){
            String input = scan.nextLine();
            Matcher m = p.matcher(input);
            if(m.find()){
                System.out.println("VALID");
            }
            else{
                System.out.println("INVALID");
            }
        }
    }
}
