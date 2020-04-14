import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        
        s = s.trim(); // so that .split() works properly

        if(s.length() == 0 || s == null){
            System.out.println(0);
            return ;
        }

        
        //split all non alphavetic character
        String[] tokens = s.split("[^a-zA-Z]+");


        System.out.println(tokens.length);
         for(String item: tokens){
            System.out.println(item);
        }
    }
}

