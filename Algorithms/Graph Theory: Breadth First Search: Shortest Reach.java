import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bfs function below.
    static int[] bfs(ArrayList<ArrayList<Integer>> adj, int s, int[] distance){
        boolean visited[] = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(s);
        visited[s] = true;
        distance[s] = 0;

        while(!queue.isEmpty()){
            int u = queue.poll();

            Iterator<Integer> it = adj.get(u).iterator();
            while(it.hasNext()){
                int v = it.next();

                if(!visited[v]){
                    visited[v] = true;
                    distance[v] = distance[u] + 6;
                    queue.add(v);
                }
            }
        }

        return distance;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int distance[] = new int[n];
            for(int i = 0; i < n; i++){
                adj.add(new ArrayList<Integer>());
                distance[i] = -1;
            }

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            int s = scanner.nextInt() - 1;

            //call bfs function to update distance
            distance = bfs(adj, s, distance);

            for (int i = 0; i < distance.length; i++) {

                if (i != s) {
                    System.out.print(distance[i] + " ");
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
