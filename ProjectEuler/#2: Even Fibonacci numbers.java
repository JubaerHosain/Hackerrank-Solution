import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            long sum = 0;

            long firstNum = 0;
            long secondNum = 1;
            long nextNum = 1;;

            while(nextNum < n){
                if(nextNum%2 == 0){
                    sum += nextNum;
                }

                nextNum = firstNum + secondNum;
                firstNum = secondNum;
                secondNum = nextNum;
            }

            System.out.println(sum);
        }
    }
}
