import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Graph {
    private enum Color{
        WHITE, GRAY, BLACK;
    }
    
    private static long MOD =  1000000000;
    private ArrayList<Integer>[] Adj, rAdj;
    private Color[] color;
    boolean[] cycleSrc;
    
    public Graph(int nodes){
        Adj = new ArrayList[nodes];
        rAdj = new ArrayList[nodes];
        color = new Color[nodes];
        cycleSrc = new boolean[nodes];
        
        for(int i = 0; i < nodes; i++){
            Adj[i] = new ArrayList<>();
            rAdj[i] = new ArrayList<>();
        }
    }
    
    public void AddEdge(int src, int dest){
        Adj[src].add(dest);
        rAdj[dest].add(src);
    }
    
    private void DFS(int u, boolean[] cycle) {
        color[u] = Color.GRAY;
        
        for(Integer v: Adj[u]){
            if(color[v] == Color.WHITE){
               DFS(v, cycle);
            }
            else if(color[v] == Color.GRAY){
                cycle[v] = true;
            }
        }
        
        color[u] = Color.BLACK;
    }
    
    private void rDFS(int u) {
        color[u] = Color.GRAY;
        
        for(Integer v: rAdj[u]){
            if(color[v] == Color.WHITE){
               rDFS(v);
            }
        }
        
        color[u] = Color.BLACK;
    }
    
    public boolean hasCycle(int src, int dest){
        Arrays.fill(color, Color.WHITE); 
        DFS(src, cycleSrc);                       //to find cycle from source vertex
        Arrays.fill(color, Color.WHITE);               //reset colors
        rDFS(dest);                              //to find cycle form destination vertex(run dfs on reverse adj) 
        
        for(int i = 0; i < Adj.length; i++){
            if(cycleSrc[i] && color[i] == Color.BLACK){ //any node from src cycle and fully explored from dest rAdj is common       
                return true;
            }
        }
        
        return false;
    }
    
    public  long countPath(int u, int dest, long[] result){
        if(cycleSrc[u]){
            return 0;
        }
        else if(u == dest){
            return 1;
        }
        else if(result[u] != -1){
            return result[u];
        }
        
        long count = 0;
        for(Integer v: Adj[u]){
            count = (count + countPath(v, dest, result))%MOD;
        }
        
        return result[u] = count;
    }
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        Graph graph;
        
        int nodes = scan.nextInt(); 
        int edges = scan.nextInt();
        
        graph = new Graph(nodes);
        int src, dest;
        for(int i = 0; i < edges; i++){
            src = scan.nextInt();   src--;
            dest = scan.nextInt();  dest--;
           
            graph.AddEdge(src, dest);
        }
        
        long[] result = new long[nodes];
        Arrays.fill(result, -1);
        src = 0; dest = nodes-1;
        if(graph.hasCycle(src, dest)){
            System.out.print("INFINITE PATHS");
        }
        else{
            System.out.println(graph.countPath(src, dest, result));
        }
        
    }
}
