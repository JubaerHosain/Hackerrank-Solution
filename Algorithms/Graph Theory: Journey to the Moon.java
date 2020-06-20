import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    static long JourneyToMoon(int n, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Long> comp = new ArrayList<Long>();
        long counter;
        
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                counter = 1;
                Stack<Integer> stack = new Stack<Integer>();
                stack.push(i);
                visited[i] = true;

                while(!stack.empty()){
                    int u = stack.pop();
                    Iterator<Integer> it = adj.get(u).iterator();

                    while(it.hasNext()){
                        int v = it.next();

                        if(!visited[v]){
                            visited[v] = true;
                            stack.push(v);
                            counter++;
                        }
                    }
                }
                comp.add(counter);
            }
        }

        long result = 0, prev = 0;
        for(int i = 0; i < comp.size(); i++){
            result += prev*comp.get(i);
            prev += comp.get(i);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        int n = scan.nextInt();
        int p = scan.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < p; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        long result = JourneyToMoon(n, adj);

        System.out.println(result);
    }
}
