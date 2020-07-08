import java.util.Scanner;

public class Plant {
    static int countPlant(int[] array, int k){
        int result = 0, n = array.length, i = 0;
        
        while(i < n){
            boolean found = false;
            for(int j = i+k-1; (j >= 0 && j >= i-k+1); j--){
                if(j < n && array[j] == 1){
                    result++;
                    i  = j + k;                             //Position for next plant
                    found = true;
                }
            }
            
            if(!found){
                return -1;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] array = new int[n];
        
        for(int i = 0; i < n; i++){
            array[i] = scan.nextInt();
        }
        
        System.out.println(countPlant(array, k));
    }
}
