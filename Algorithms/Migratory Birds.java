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

    // Complete the migratoryBirds function below.
    
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int result[] = new int[6];
        int max = 0;
        int bird = 0;

        for(int i = 0; i < n; i++){
            result[scan.nextInt()]++;
        }

        for(int i = 0; i <= 5; i++){
            if(max < result[i]){
                max = result[i];
                bird = i;
            }
        }

        System.out.println(bird);
    }
}
