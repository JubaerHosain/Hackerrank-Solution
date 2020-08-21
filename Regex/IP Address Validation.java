import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        String num = "([01]?\\d{1,2}|2[0-4]\\d|25[0-5])";
        String ipv4 = num + "." + num + "." + num + "." + num;

        num = "[a-f\\d]{1,4}";
        String ipv6 = num + ":" + num + ":" + num + ":" + num + ":" + num + ":" +num + ":"  +num + ":" +num; 


        while(n-- > 0){
            String input = scan.nextLine();

            if(Pattern.matches(ipv4, input)){
                System.out.println("IPv4");
            }
            else if(Pattern.matches(ipv6, input)){
                System.out.println("IPv6");
            }
            else{
                System.out.println("Neither");
            }
        }
    }
}
