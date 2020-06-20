import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    static long roadsAndLibraries(int n, long clib, long croad, ArrayList<ArrayList<Integer>> adj){
        if(clib <= croad){
            return n*clib;
        }

        long cost = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                long localCost = clib;
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
                            localCost += croad;
                            stack.push(v);
                        }
                    }
                }
                cost += localCost;
            }
        }

        return cost;
    }

    public static void main(String[] args) throws IOException {
        int q = scan.nextInt();

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            long c_lib = scan.nextLong();
            long c_road = scan.nextLong();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < n; i++){
                adj.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < m; i++) {
                int u = scan.nextInt();
                u--;
                int v = scan.nextInt();
                v--;

                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            long result = roadsAndLibraries(n, c_lib, c_road, adj);

            System.out.println(result);
        }

    }
}
