import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();


        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            pq.add(AItem);
        }

        int cnt = 0;
        while(pq.size() > 1 && pq.peek() < k){
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + 2 * b);
            cnt++;
        }

        int result;
        if(pq.peek() < k){
            result = -1;
        }
        else{
            result = cnt;
        }

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
