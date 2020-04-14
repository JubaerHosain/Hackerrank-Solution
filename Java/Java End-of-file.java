import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
   
        int i = 1;
        while(scan.hasNext()){
            line = scan.nextLine();
            System.out.println(i + " " + line);
            i++;
        }
    }
}

