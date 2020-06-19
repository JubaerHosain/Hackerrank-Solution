import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(HashMap<String, Integer> magazine, HashMap<String, Integer> note) {
        if(magazine.size() < note.size()){
            System.out.println("No");
            return;
        }

        for(Object word: note.keySet()){
            if(magazine.get(word) != null){
                if(note.get(word) > magazine.get(word)){
                    System.out.println("No");
                    return;
                }
            }
            else{
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        HashMap<String, Integer> magazine = new HashMap<String, Integer>();

        String[] Items = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            if(magazine.get(Items[i]) == null){
                magazine.put(Items[i], 1);

            }
            else{
                magazine.put(Items[i], magazine.get(Items[i])+1);
            }
        }

        HashMap<String, Integer> note = new HashMap<String, Integer>();

        Items = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        
        for (int i = 0; i < n; i++) {
            if(note.get(Items[i]) == null){
                note.put(Items[i], 1);

            }
            else{
                note.put(Items[i], note.get(Items[i])+1);
            }
        }


        checkMagazine(magazine, note);

        scanner.close();
    }
}
