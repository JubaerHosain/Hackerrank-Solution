import java.io.*;
import java.util.*;


public class Solution {
    static int getMinimumCost(int n, int k, PriorityQueue<Integer> pq){
        int result = 0;

        if(n <= k){
            while(!pq.isEmpty()){
                result += pq.poll();
            }
        }
        else{
            int pp[] = new int[k];

            while(!pq.isEmpty()){
                int i = 0;
                while(i < k && !pq.isEmpty()){
                    result += ( (1+pp[i]) * pq.poll() );
                    pp[i]++;
                    i += 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer n1, Integer n2){
                return n2-n1;
            }
        });

        int n = scan.nextInt();
        int k = scan.nextInt();

        for(int i = 0; i < n; i++){
            int price = scan.nextInt();
            pq.add(price);
        }

        System.out.println(getMinimumCost(n, k, pq));
    }
        
}
