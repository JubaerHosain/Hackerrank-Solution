import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            int grade = scan.nextInt();

            if(grade < 38){
                arr[i] = grade;
            }
            else{
                int f1 = grade + 1;
                int f2 = grade + 2;
                if(f1%5 == 0){
                    arr[i] = f1;
                }
                else if(f2%5 == 0){
                    arr[i] = f2;
                }
                else{
                    arr[i] = grade;
                }
            }
        }

        for(int a: arr){
            System.out.println(a);
        }
    }
}
