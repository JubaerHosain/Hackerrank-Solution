import java.util.*;
import java.io.*;


public class Solution {
    static class Node{
        int node, cost;

        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    static class cmp implements Comparator<Node>{
        public int compare(Node n1, Node n2){
            return (n1.cost - n2.cost);
        }
    }

    static void Dijkstra(ArrayList<Node>[] adj, int src){
        int[] cumu = new int[adj.length];
        Arrays.fill(cumu, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<Node>(adj.length, new cmp()); 
        cumu[src] = 0;
        queue.add(new Node(src, 0));

        while(!queue.isEmpty()){
            Node u = queue.poll();

            for(Node v : adj[u.node]){
                if(Math.max(v.cost-cumu[u.node], 0)+cumu[u.node] < cumu[v.node]){
                    cumu[v.node] = Math.max(v.cost-cumu[u.node], 0)+cumu[u.node];
                    queue.add(new Node(v.node, cumu[v.node]));
                }
            }
        }
        
        if(cumu[adj.length-1] != Integer.MAX_VALUE){
            System.out.println(cumu[adj.length-1]);
        }
        else{
            System.out.println("NO PATH EXISTS");
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int nodes = scan.nextInt();
        int edges = scan.nextInt();

        ArrayList<Node>[] adj = new ArrayList[nodes];
        for(int i = 0; i < nodes; i++){
            adj[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < edges; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            int cost = scan.nextInt();
            u--; v--;

            adj[u].add(new Node(v, cost));
            adj[v].add(new Node(u, cost));
        }

        Dijkstra(adj, 0);
    }
}
