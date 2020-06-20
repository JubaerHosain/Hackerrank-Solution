import java.io.*;
import java.util.*;

public class Solution {
    static Scanner scan = new Scanner(System.in);

    static double getMean(int array[]){
        double sum = 0;

        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }

        return sum/array.length;
    }

    static double getMedian(int array[]){
        Arrays.sort(array);
        double median;

        if(array.length%2 == 0){
            median = (double)(array[(array.length/2)-1] + array[array.length/2])/2;
        }
        else{
            median = (double)array[(array.length-1)/2];
        }

        return median;
    }

    static  int getMode(int array[]){
        int current = array[0], count = 1;
        int max = 1, mode = current;

        for(int i = 1; i < array.length; i++){
            if(current  == array[i]){
                count++;
            }
            else{
                count = 1;
                current = array[i];
            }

            if(max < count){
                max = count;
                mode = current;
            }
        }

        return mode;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int n = scan.nextInt();
        int array[] = new int[n];

        for(int i = 0; i < n; i++){
            array[i]  = scan.nextInt();
        }
        scan.close();

        System.out.println(getMean(array));
        System.out.println(getMedian(array));
        System.out.println(getMode(array));
    }
}
