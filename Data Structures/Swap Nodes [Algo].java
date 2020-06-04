 import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static class Node{
        int data;
        int depth;
        Node left;
        Node right;

        public Node(int data, int depth, Node left, Node right){
            this.data = data;
            this.depth = depth;
            this.left = left;
            this.right = right;
        } 
    }

    static void swapInOrder(Node root, int depth, int k){
        if(root == null){
            return;
        }

        swapInOrder(root.left, depth+1, k);
        swapInOrder(root.right, depth+1, k);

        if(depth >= k && depth % k == 0){
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    static void printInOrder(Node root, List<Integer> result){
        if(root == null){
            return;
        }

        printInOrder(root.left, result);
        result.add(root.data);
        printInOrder(root.right, result);
    }
    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */

        int numberOfNode = indexes.length;
        int numberOfQuery = queries.length;

        Node root = new Node(1, 1, null, null);
        Node current = root;

        Queue<Node> q = new LinkedList<Node>();
        q.offer(current);

        int n = 0;
        while(n < numberOfNode){
            current = q.poll();

            int left = indexes[n][0];
            int right = indexes[n][1];

            current.left = (left == -1) ? null : new Node(left, current.depth+1, null, null);
            current.right = (right == -1) ? null : new Node(right, current.depth+1, null, null);
            if(current.left != null){
                q.offer(current.left);
            }
            if(current.right != null){
                q.offer(current.right);
            }

            n++;
        }

        int result[][] = new int[numberOfQuery][numberOfNode];
        for(int i = 0; i < numberOfQuery; i++){
            swapInOrder(root, 1, queries[i]);
            List<Integer> res = new LinkedList<Integer>();
            printInOrder(root, res);
            result[i] = res.stream().mapToInt(r->r).toArray();
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
