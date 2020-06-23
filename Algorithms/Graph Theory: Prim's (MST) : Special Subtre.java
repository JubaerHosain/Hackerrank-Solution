import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Graph{
    //node for adj list
    class Node{
        int dest, weight;
        public Node(int dest, int weight){
            this.dest = dest;
            this.weight = weight;
        }
    }
    
    int vertices;
    LinkedList<Node>[] adj;

    public Graph(int vertices){
        this.vertices = vertices;
        adj = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++){
            adj[i] = new LinkedList<Node>();
        }
    }

    public void addEdge(int src, int dest, int weight){
        Node n1 = new Node(dest, weight);
        Node n2 = new Node(src, weight);
        adj[src].add(n1);
        adj[dest].add(n2);
    }

    public int primMST(int src){
        ArrayList<Integer> added = new ArrayList<Integer>();
        boolean visited[] = new boolean[this.vertices];
        for(int i = 0; i < this.vertices; i++){
            visited[i] = false;
        }
        visited[src] = true;

        added.add(src);
        int totalEdge = 1, mstWeight = 0;
        while(totalEdge <= this.vertices-1){
            int min = Integer.MAX_VALUE, next = 0;
            for(Integer u: added){
                for(Node v: adj[u]){ 
                    if(!visited[v.dest] && v.weight < min){
                        min = v.weight;
                        next = v.dest;
                    }
                }
            }
            mstWeight += min;
            visited[next] = true;
            added.add(next);
            totalEdge++;
        }

        return mstWeight;
    }
}

public class Solution {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int nodes = scan.nextInt();
        int edges = scan.nextInt();
        Graph g = new Graph(nodes);

        for(int i = 0; i < edges; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();

            g.addEdge(u-1, v-1, w);
        }

        int start = scan.nextInt();
        System.out.println(g.primMST(start-1));
    }
}
