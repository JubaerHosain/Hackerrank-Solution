import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    static Scanner scan = new Scanner(System.in);
    public static HashMap<Integer, Integer> adj[];
    public static int[] distance;

    static class Node{
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static class myCmp implements Comparator<Node>{
        public int compare(Node n1, Node n2){
            return (n1.weight > n2.weight) ? 1 : -1;
        }
    }

    public static void Dijkstra(int src) {
        boolean[] visited = new boolean[adj.length];
        PriorityQueue<Node> queue = new PriorityQueue<Node>(adj.length, new myCmp());
        queue.add(new Node(src, 0));
        distance[src] = 0;

        while (!queue.isEmpty()) {
            Node u = queue.poll();
            if (!visited[u.vertex]) {
            visited[u.vertex] = true;
            for(Map.Entry<Integer, Integer> v: adj[u.vertex].entrySet())
                if (u.weight + v.getValue() < distance[v.getKey()]) {
                    distance[v.getKey()] = u.weight + v.getValue();
                    queue.add(new Node(v.getKey(), distance[v.getKey()]));
                }
            }
        }
    }

public static void main(String[] args) {
    int t = scan.nextInt();
    while(t-- > 0){
        int n = scan.nextInt();
        int m = scan.nextInt();

        adj = new HashMap[n];
        distance = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashMap<Integer, Integer>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int j = 0; j < m; j++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();
            u--;
            v--;

            if (!adj[u].containsKey(v) || adj[u].get(v) > w) {
                adj[u].put(v, w);
            }
            if (!adj[v].containsKey(u) || adj[v].get(u) > w) {
                adj[v].put(u, w);
            }
        }

        int src = scan.nextInt();
        src--;
        Dijkstra(src);

        StringBuilder result = new StringBuilder("");
        for (int j = 0; j < n; j++) {
            if (src != j){
                if (distance[j] == Integer.MAX_VALUE) {
                    result.append("-1 ");
                }
                else {
                    result.append(distance[j]);
                    result.append(" ");
                }
            }
        }
        result.append("\n");
        System.out.print(result.toString());
    }
}
}
