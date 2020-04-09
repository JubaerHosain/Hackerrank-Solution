import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int inverse[] = new int[n+1];

        for(int x = 1; x <= n; x++){
            int i = sc.nextInt();
            inverse[i] = x;
        }
        sc.close();

        for(int x = 1; x <= n; x++){
            System.out.println(inverse[inverse[x]]);
        }
    }
}
