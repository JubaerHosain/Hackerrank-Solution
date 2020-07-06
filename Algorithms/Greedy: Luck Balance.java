import java.util.*;
import java.io.*;


public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer n1, Integer n2){
                return n2-n1;
            }
        });

        int n = scan.nextInt();
        int k = scan.nextInt();

        int balance = 0;
        for(int i = 0; i < n; i++){
            int l = scan.nextInt();
            int t = scan.nextInt();

            if(t == 0){
                balance += l;
            }
            else{
                pq.add(l);
            }
        }

        int count = 1, total = 0, need = 0;

        while(!pq.isEmpty()){
            total += pq.poll();
            if(count <= k){
                need = total;
            }
            count++;
        }

        System.out.println((balance+need)-(total-need));
    }
}
