import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scan.nextInt();
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); 


        while(q-- > 0){
            int in = scan.nextInt();

            if(in == 1){
                int element = scan.nextInt();
                pQueue.add(element);
            }
            else if(in == 2){
                int element = scan.nextInt();
                pQueue.remove(element);
            }
            else{
                System.out.println(pQueue.peek());
            }
        }
    }
}
