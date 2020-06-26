import java.util.Scanner;

public class Graph {
    static Scanner scan = new Scanner(System.in);
    static int inf = Integer.MAX_VALUE;
    
    static int[][] FloydWarshall(int[][] dist){
        
        for(int  k = 0; k < dist.length; k++){
            for(int i = 0; i < dist.length; i++){
                for(int j = 0; j < dist.length; j++){
                    if(dist[i][k] != inf && dist[k][j] != inf && dist[i][k]+dist[k][j] < dist[i][j]){
                        dist[i][j]  = dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        
        return dist;
    }
    
    public static void main(String args[]){
        int nodes = scan.nextInt();
        int vertices = scan.nextInt();
        
        int[][] dist = new int[nodes][nodes]; 

        //Initialize distances as infinity
        for(int i = 0; i < nodes; i++){
            for(int j = 0; j < nodes; j++){
                if(i != j){
                    dist[i][j] = inf;
                }
            }
        }
        
        for(int i = 0; i < vertices; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();
            u--; v--;
            
            dist[u][v] = w;
        }

        dist = FloydWarshall(dist);
        
        int q = scan.nextInt();
        while(q-- > 0){
            int a = scan.nextInt();
            int b = scan.nextInt();
            a--; b--;

            if(dist[a][b] != inf){
                System.out.println(dist[a][b]);
            }
            else{
                System.out.println(-1);
            }
        }
    }
}
