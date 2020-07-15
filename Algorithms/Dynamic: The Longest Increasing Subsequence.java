import java.util.Arrays;
import java.util.Scanner;

//NlogN solution
public class LIS {
    private static int getCeilPos(int[] arr, int[] sub, int low, int high, int val){
        while(low <= high){
            int mid = (low+high)/2;
            
            if(arr[sub[mid]] < val){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        
        return low;
    }
    
    private static int lis(int n, int[] arr){
        int[] sub = new int[n];

        int length = 0;
        for(int i = 0; i < n; i++){
            int low = 0, high = length;
            
            int pos = getCeilPos(arr, sub, low, high, arr[i]);
            sub[pos] = i;
            
            if(pos > length){
                length = pos;
            }
        }
        
        return length+1;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }
        
        System.out.println(lis(n, arr));
    }
}
