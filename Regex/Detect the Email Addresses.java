import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    static Pattern p = Pattern.compile("\\w+(\\.\\w+)*@\\w+(\\.\\w+)+");
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        SortedSet<String> set = new TreeSet<>();
        while(n-- > 0){
            String email = scan.nextLine();
            Matcher m = p.matcher(email);

            while(m.find()){
                set.add(m.group());
            }
        }

        System.out.println(String.join(";", set.toArray(new String[0])));
        scan.close();
    }
}
