import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the decentNumber function below.
    static void decentNumber(int n) {
        int five = 0, three = 0;
        String answer = "";

        while(n > 0){
            if(n % 3 == 0){
                while(n > 0){
                    five++;
                    n -= 3;
                }
            } 
            else if(n % 5 == 0){
                three++;
                n -= 5;
           }
           else{
               five++;
               n -= 3;
           }
        }

        if(n < 0){
            System.out.println(-1);
            return;
        }
        else{
            for(int i = 0; i < five; i++){
                System.out.print("555");
            }
            for(int i = 0; i < three; i++){
                System.out.print("33333");
            }
            System.out.println();
            return;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            decentNumber(n);
        }

        bufferedReader.close();
    }
}
