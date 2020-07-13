import java.io.*;
import java.util.*;


public class CoinChange {
    public static long getWays(int n, int sum, int[] coins) {
        long[][] dp = new long[n][sum+1];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= sum; j++){
                if(j == 0){
                    dp[i][j] = 1;
                }
                else{
                    long excluding = 0;
                    long including = 0;
                    
                    if(i > 0){                                                  //excluding coins[i]
                        excluding  = dp[i-1][j];
                    }
                    if(j >= coins[i]){                                          //including coins[i]
                        including = dp[i][j-coins[i]];
                    }
                    
                    dp[i][j] = excluding + including;
                }
                
            }
        }
        
        return dp[n-1][sum];
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        
        int sum = scan.nextInt();
        int n = scan.nextInt();
        int[] coins = new int[n];
        
        for(int i = 0; i  < n; i++){
            coins[i] = scan.nextInt();
        }
        
        System.out.println(getWays(n, sum, coins));
    }
}
