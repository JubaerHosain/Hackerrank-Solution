import java.util.*;

public class Solution{
    static Scanner scan = new Scanner(System.in);
    
    static class Graph{
        HashMap<Integer, ArrayList<Integer>> nodes;
        
        public Graph(int e){
            nodes = new HashMap<>();
            for(int i = 1; i <= 2*e; i++){
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                nodes.put(i, list);
            }
        }
        
        public void Set_Edge(int u, int v){
            ArrayList<Integer> list1 = nodes.get(u);
            ArrayList<Integer> list2 = nodes.get(v);
            
            if(list1 != list2){
                list1.addAll(list2);
                list2.forEach(i -> nodes.put(i, list1));
            }
        }
        
        public void print_Result(){
            ArrayList<Integer> vertices = new ArrayList<Integer>();
            
            for(ArrayList<Integer> list : nodes.values()){
                if(list.size() > 1){
                    vertices.add(list.size());
                }
                list.clear();
            }
            
            System.out.println(Collections.min(vertices) + " " + Collections.max(vertices));
        }
    }
    
    
    public static void main(String []args){
        int n = scan.nextInt();
        Graph g = new Graph(n);
        
        for(int i = 1; i <= n; i++){
            g.Set_Edge(scan.nextInt(), scan.nextInt());
        }
        
        g.print_Result();
    }
}


