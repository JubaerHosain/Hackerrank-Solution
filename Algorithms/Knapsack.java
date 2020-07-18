
import java.util.Scanner;


public class Knapsack {
    private static int unboundedKnapsack(int n, int k, int[] w){
        int[][] dp = new int[n][k+1];
        
        for(int i = 0; i < n;  i++){
            for(int j = 0; j <= k; j++){
                int excluding = 0, including = 0;
                
                if(i > 0){
                    excluding = dp[i-1][j];
                }
                if(j >= w[i]){
                    including = w[i] + dp[i][j-w[i]];
                }
                
                dp[i][j] = Math.max(excluding, including);
            }
        }
        
        return dp[n-1][k];
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        
        while(test-- > 0){
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[] w = new int[n];
        
            for(int i = 0; i < n; i++){
                w[i] = scan.nextInt();
            }
            
            System.out.println(unboundedKnapsack(n, k, w));
        }
    }
}
