import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
            Pattern p = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = p.matcher(line);


            boolean found = false;
            while(m.find()){
                System.out.println(m.group(2));
                found = true;
            }
			
            if(!found){
                System.out.println("None");
            }

			testCases--;
		}
	}
}



