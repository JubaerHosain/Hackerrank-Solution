import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int query = scan.nextInt();
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> maxStack = new Stack<Integer>();

        while(query-- > 0){
            int q = scan.nextInt();

            if(q == 1){
                int x = scan.nextInt();
                stack.push(x);

                if(maxStack.isEmpty() || x >= maxStack.peek()){
                    maxStack.push(x);
                }
            }
            else if(q == 2){
                int pop = stack.pop();
                if(pop == maxStack.peek()){
                    maxStack.pop();
                }
            }
            else{
                System.out.println(maxStack.peek());
            }
        }
    }
}
