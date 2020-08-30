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

            long i = 2, max = 2;
            while(n > 1){
                if(n%i == 0){
                    while(n%i == 0){
                        max = i;
                        n /= i;
                    }
                }
                i++;
                if(i*i > n){
                    max = Math.max(max, n);
                    break;
                }
            }

            System.out.println(max);
        }
    }
}
