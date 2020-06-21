import java.io.*;
import java.util.*;

public class Solution {

    static Scanner scan = new Scanner(System.in);

    static double getMedian(int x[], int start, int end){
        if((end-start)%2 == 0){                             // odd number of elements
            return x[(start+end)/2];
        }
        else{
            return (x[(start+end)/2]+x[(start+end)/2 + 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int n = scan.nextInt();
        int x[] = new int[n];
        int f[] = new int[n];
        int tf = 0;
        
        for(int i = 0; i < n; i++){
            x[i] = scan.nextInt();
        }

        for(int i = 0; i < n; i++){
            f[i] = scan.nextInt();
            tf += f[i];
        }

        int data[] = new int[tf];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < f[i]; j++){
                data[index++] = x[i];
            }
        }

        Arrays.sort(data);

        double q1 = getMedian(data, 0, data.length/2 - 1);
        double q3 = getMedian(data, (data.length+1)/2, data.length-1);

        System.out.printf("%.1f\n", q3-q1);
    }
}
