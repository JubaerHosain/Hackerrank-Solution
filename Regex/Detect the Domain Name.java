import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    static Pattern p = Pattern.compile("http[s]?:\\/\\/(ww[w2]\\.)?(([a-zA-Z0-9\\-]+\\.)+[a-zA-Z0-9\\-]+)");
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        SortedSet<String> set = new TreeSet<>();
        while(n-- > 0){
            String email = scan.nextLine();
            Matcher m = p.matcher(email);

            while(m.find()){
                set.add(m.group(2));
            }
        }

        System.out.println(String.join(";", set.toArray(new String[0])));
        scan.close();
    }
}
