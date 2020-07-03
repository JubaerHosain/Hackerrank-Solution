import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution { 
    private int[] dist;
    private boolean[] visited;
    private ArrayList<Integer>[] adj;
    
    public Solution(){
        dist = new int[101];
        visited = new boolean[101];
        adj = new ArrayList[101];
        for(int i = 1; i <= 100; i++){
            dist[i] = -1;
            visited[i] = false;
            adj[i]  = new ArrayList<Integer>();
            
            for(int j = i+1; j <= i+6 && j <= 100; j++){
                adj[i].add(j);
            }
        }
    }

    public void replace(int src, int dest){
        int i = src-1;
        while(i >=1 && i >= src-6){
            adj[i].set(adj[i].indexOf(src), dest);
            i--;
        }
    }
    
    public void DFS(int src){
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.add(src);
        dist[src] = 0;
        visited[src] = true;
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            
            for(Integer v: adj[u]){
                if(!visited[v]){
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    queue.add(v);
                }
            }
        }
    }

    public static void main(String args[]) throws IOException{ 
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        
        while(test-- > 0){
            Solution obj = new Solution();
            
            int n = scan.nextInt();
            for(int i = 0; i < n; i++){
                obj.replace(scan.nextInt(), scan.nextInt());
            }
            
            int m = scan.nextInt();
            for(int i = 0; i < m; i++){
                obj.replace(scan.nextInt(), scan.nextInt());
            }
            
            obj.DFS(1);
            System.out.println(obj.dist[100]);
        }
    } 
} 
