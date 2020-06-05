import java.io.*;
import java.util.*;

public class Solution {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your             class should be named Solution. */

        Queue<Integer> queue = new LinkedList<Integer>();
        int t = scan.nextInt();

        while(t-- > 0){
            int q = scan.nextInt();

            if(q == 1){
                int x = scan.nextInt();
                queue.offer(x);
            }
            else if(q == 2){
                queue.poll();
            }
            else{
                System.out.println(queue.peek());
            }
        }
    }
}
