import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
       public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int s1 = 0;
        int s2 = 0;

        for(int i = 0, j = n - 1; i < n; i++, j--){ 
            
            String[] inputLine = scan.nextLine().split(" ");

            s1 = s1 + Integer.parseInt(inputLine[i]);
            s2 = s2 + Integer.parseInt(inputLine[j]);
        }
        
        System.out.println(Math.abs(s1 - s2));
    }
}
