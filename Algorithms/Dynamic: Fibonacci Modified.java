
import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {
    static void fibonacciModified(int t01, int t02,  int n){
        BigInteger t1 = new BigInteger(t01+"");
        BigInteger t2 = new BigInteger(t02+"");
        BigInteger temp = new BigInteger("0");
        
        for(int i = 3; i <= n;  i++){
            temp = t2;
            t2 = t2.multiply(t2);
            t2 = t2.add(t1);
            t1 = temp;
        }
        
        System.out.println(t2);
    }
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int t1 = scan.nextInt();
        int t2 = scan.nextInt();
        int n = scan.nextInt();
        
        fibonacciModified(t1, t2, n);
    }
}
