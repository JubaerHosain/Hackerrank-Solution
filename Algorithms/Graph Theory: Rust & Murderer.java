import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution { 
    private static int[] rustMurdered(HashSet<Integer>[] adj, int src) {
        int[] dist = new int[adj.length];
        HashSet<Integer> unVisited = new HashSet<>();
        for(int i = 0; i < adj.length; i++){
            unVisited.add(i);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        unVisited.remove(src);
        
        while(!queue.isEmpty()){
            HashSet<Integer> visited = new HashSet<>();
            int u = queue.poll();
            
            for(Integer v: unVisited){
                if(adj[u] == null || !adj[u].contains(v)){
                    dist[v] = dist[u]+1;
                    visited.add(v);
                    queue.add(v);
                }
            }
            unVisited.removeAll(visited);
        }
        
        return dist;
    }

    public static void main(String args[]) throws IOException{ 
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        HashSet<Integer>[] adj;
        
        
        while(test-- > 0){
            int nodes = scan.nextInt();
            int edges = scan.nextInt();
            adj = new HashSet[nodes];
            
            for(int i = 0; i < edges; i++){
                int u = scan.nextInt();
                int v = scan.nextInt();
                u--; v--;
                
                if(adj[u] == null){
                    adj[u] = new HashSet<>();
                    adj[u].add(v);
                }
                else{
                    adj[u].add(v);
                }
                
                if(adj[v] == null){
                    adj[v] = new HashSet<>();
                    adj[v].add(u);
                }
                else{
                    adj[v].add(u);
                }
            }
            
            int src = scan.nextInt();
            src--;
            int[] result = rustMurdered(adj, src);
            for(int i = 0; i < result.length; i++){
                if(i != src){
                    System.out.print(result[i]+" ");
                }
            }
            System.out.println();
        }
    } 
} 
