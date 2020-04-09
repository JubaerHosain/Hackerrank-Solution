import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static Scanner scan = new Scanner(System.in);

    public static void main(String args[]){
        int v = scan.nextInt();
        int n = scan.nextInt();
        
        for(int i = 0; i < n; i++){
            if(scan.nextInt() == v){
                System.out.println(i);
            }
        }
    }
}
