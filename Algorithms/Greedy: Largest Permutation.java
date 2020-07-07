import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author jubaer
 */
public class Solution {
    static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    
    static void largestPermutation(HashMap<Integer, Integer> map, int[] array, int k){
        int i = 0, sw = 0, n = array.length;
        
        while(sw < k && sw < n && i < n){
            int max = n-i;
            int x = i;
            int y = map.get(max);
            
            if(array[x] < array[y]){
                swap(array, x, y);
                map.put(array[y], y);
                sw++;
            }
            i++;
        }
    }
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] array;
        
        int n = scan.nextInt();
        int k = scan.nextInt();
        array = new int[n];
        
        for(int i = 0; i < n; i++){
            array[i] = scan.nextInt();
            map.put(array[i], i);
        }
        
        largestPermutation(map, array, k);
        
        for(int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
    }
}
