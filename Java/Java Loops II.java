import java.util.*;
import java.io.*;
import java.lang.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            int s = 0;

            for(int N = 0; N < n; N++){
                s=0;
                s = s + a;
                for(int t1 = 0; t1 <= N; t1++){
                   s = s + (int)Math.pow(2,t1) * b; 
                }
                System.out.print(s + " ");
            }
            System.out.println();
        }
        in.close();
    }
}

