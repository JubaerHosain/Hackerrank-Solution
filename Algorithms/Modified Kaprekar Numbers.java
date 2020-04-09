import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int p = scan.nextInt();
        int q = scan.nextInt();

        boolean flag = false;

        if(p == 1){
            System.out.print(p + " ");
            flag = true;
        }

        for(long i = p; i <= q; i++){
            long s = i * i;
            String squre = String.valueOf(s);

            if(squre.length() > 1){
                long left = Long.parseLong(squre.substring(0, (int)squre.length()/2));
                long right = Long.parseLong(squre.substring((int)squre.length()/2, (int)squre.length()));

                if(left + right == i){
                    System.out.print(i + " ");
                    flag = true;
                }
            }
        }

        if(!flag){
            System.out.println("INVALID RANGE");
        }
    }
}
