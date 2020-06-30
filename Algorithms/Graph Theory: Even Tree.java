import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int DFS(LinkedList<Integer>[] adj, int u){
        visited[u] = true;
        int node = 0;

        for(Integer v: adj[u]){
            if(!visited[v]){
                int nextNode = DFS(adj, v);

                if(nextNode%2 == 0){
                    ans++;
                }
                else{
                    node += nextNode;
                }
            }
        }

        return node+1;
    }

    static int ans = 0;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int nodes = scan.nextInt();
        int edges = scan.nextInt();

        LinkedList<Integer>[] adj = new LinkedList[nodes+1];
        visited = new boolean[nodes+1];
        for(int i = 0; i < nodes+1; i++){
            adj[i] = new LinkedList<Integer>();
            visited[i] = false;
        }
        
        for(int i = 0; i < edges; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();

            adj[u].add(v);
            adj[v].add(u);
        }

        DFS(adj, 1);
        System.out.println(ans);
    }
}
