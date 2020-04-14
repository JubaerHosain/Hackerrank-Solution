import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.println(CapFirstLetter(A) + " " + CapFirstLetter(B));

        
    }

    public static String CapFirstLetter(String string){
        if(string == null || string.length() == 0){
            return "";
        }
        else{
            return string.substring(0,1).toUpperCase() + string.substring(1);
        }
    }
}



