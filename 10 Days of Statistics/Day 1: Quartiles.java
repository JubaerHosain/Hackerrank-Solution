import java.io.*;
import java.util.*;

public class Solution {

    static Scanner scan = new Scanner(System.in);

    static int getMedian(int x[], int start, int end){
        if((end-start)%2 == 0){ // odd number of elements
            return x[(start+end)/2];
        }
        else{
            return (x[(start+end)/2]+x[(start+end)/2 + 1]) / 2;
        }
    }

    public static void main(String[] args) {
        int n = scan.nextInt();
        int x[] = new int[n];
        
        for(int i = 0; i < n; i++){
            x[i] = scan.nextInt();
        }

        Arrays.sort(x);

        int q1 = getMedian(x, 0, x.length/2 - 1);
        int q2 = getMedian(x, 0, x.length-1);
        int q3 = getMedian(x, (x.length+1)/2, x.length-1);

        System.out.println(q1 + "\n" + q2 + "\n" + q3);
    }
}
