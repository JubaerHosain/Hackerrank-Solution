import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int n = scan.nextInt();

        for(int i = 0; i < n; i++){
            map.put(i+1, scan.nextInt() + scan.nextInt());
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer> >(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> o1,
            Map.Entry<Integer, Integer> o2){
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        for(Map.Entry<Integer, Integer> ite : list){
            System.out.print(ite.getKey() + " ");
        }
    }
}
