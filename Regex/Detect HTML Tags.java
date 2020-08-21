import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Pattern p = Pattern.compile("<\\s*(\\w+)[^<>]*>");
        SortedSet<String> set = new TreeSet<>();
        
        int n = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < n; i++){
            String input = scan.nextLine();
            Matcher m = p.matcher(input);
            
            while(m.find()){
                set.add(m.group(1));
            }
        }
        
        System.out.println(String.join(";", set.toArray(new String[0])));
        scan.close();
    }
}
