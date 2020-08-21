import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();
        String[] lines = new String[n];

        for(int i = 0; i < n; i++){
            lines[i] = scan.nextLine();
        }

        int q = scan.nextInt();
        scan.nextLine();

        while(q-- > 0){
            String sub = scan.next();
            int oc = 0;

            Pattern p = Pattern.compile("\\w"+sub+"\\w");
            for(String line: lines){
                Matcher m = p.matcher(line);

                while(m.find()){
                    oc++;
                }
            }

            System.out.println(oc);
        }

        scan.close();
    }
}
