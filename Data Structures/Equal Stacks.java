import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int h1 = 0, h2 = 0, h3 = 0;
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        Queue<Integer> q3 = new LinkedList<Integer>();

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            q1.add(h1Item);
            h1 += h1Item;
        }

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            q2.add(h2Item);
            h2 += h2Item;
        }

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            q3.add(h3Item);
            h3 += h3Item;
        }

        int minH = Math.min(h1, Math.min(h2, h3));
        while(h1 != h2 || h1 != h3){
            if(h1 > minH){
                h1 -= q1.poll();
            }
            minH = Math.min(h1, Math.min(h2, h3));

            if(h2 > minH){
                h2 -= q2.poll();
            }
            minH = Math.min(h1, Math.min(h2, h3));

            if(h3 > minH){
                h3 -= q3.poll();
            }
            minH = Math.min(h1, Math.min(h2, h3));
        }

        bufferedWriter.write(String.valueOf(minH));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
