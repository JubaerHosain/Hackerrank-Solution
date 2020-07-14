import java.util.Scanner;


public class MaxSum {
    static int[] maxSubarray(int n, int[] array) {
        int cur = array[0], cur1 = array[0];
        int max = array[0], max1 = array[0];
        
        for(int i = 1; i < n; i++){
            cur = Math.max(cur + array[i], array[i]);
            
            max = Math.max(max, cur);
            max1 = Math.max(max1, Math.max(max1+array[i], array[i]));
        }
   
        
        return new int[]{max, max1};
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        
        while(test -- > 0){
            int n = scan.nextInt();
            int[] array = new int[n];
            
            for(int i = 0; i < n; i++){
                array[i] = scan.nextInt();
            }
            
            int[] res = maxSubarray(n, array);
            System.out.println(res[0]+" "+res[1]);
        }
    }
}
