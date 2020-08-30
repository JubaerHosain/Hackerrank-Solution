import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static long getSum(int n){
        long multipleOfThree = (n-1)/3;
        multipleOfThree = (3*multipleOfThree*(multipleOfThree+1))/2;
        long multipleOfFive = (n-1)/5;
        multipleOfFive = (5*multipleOfFive*(multipleOfFive+1))/2;
        long multipleOfBoth = (n-1)/15;
        multipleOfBoth = (15*multipleOfBoth*(multipleOfBoth+1))/2;

        return multipleOfThree+multipleOfFive-multipleOfBoth;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            
            

            System.out.println(getSum(n));
        }
    }
}
