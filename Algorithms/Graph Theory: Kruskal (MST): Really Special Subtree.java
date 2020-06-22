import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;

public class Solution {
    static Scanner scan = new Scanner(System.in);
    static class Node{
        int u, v, w;

        public Node(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class myComparator implements Comparator<Node> { 
        public int compare(Node o1, Node  o2) 
        { 
            if(o1.w < o2.w){
                return -1;
            }
            else if(o1.w > o2.w){
                return 1;
            }
            else{
                return 0;
            }
        } 
    } 

    static long Kruskals(int n, PriorityQueue<Node> pq){
        int parent[] = new int[n];
        for(int i = 0; i < n; i++) parent[i] = -1;

        long weight = 0;
        while(!pq.isEmpty()){
            Node edge = pq.poll();

            int u = find(parent, edge.u);
            int v = find(parent, edge.v);

            if(u != v){
                weight += edge.w;
                union(parent, u, v);
            }
        }

        return weight;
    }

    static int find(int parent[], int key){
        if(parent[key] == -1){
            return key;
        }
            
        return find(parent, parent[key]);
    }

    static void union(int parent[], int x, int y){
        int xset = find(parent, x);
        int yset = find(parent, y);
            
        parent[xset] = yset;
    }

    public static void main(String[] args) throws IOException {
        int nodes = scan.nextInt();
        int edges = scan.nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(edges, new myComparator());

        for(int i = 0; i < edges; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();

            pq.add(new Node(u-1, v-1, w));
        }

        System.out.println(Kruskals(nodes, pq));
    }
}
