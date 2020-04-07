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

    
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int bill[] = new int[n];
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            bill[i] = scan.nextInt();
            if(i != k){
                sum += bill[i];
            }
        }
        sum /= 2;
        
        int b = scan.nextInt();

        if(b > sum){
            System.out.println(b-sum);
        }
        else{
            System.out.println("Bon Appetit");
        }
    }
}
