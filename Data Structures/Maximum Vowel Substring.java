import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'findSubstring' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
    public static boolean isVowel(char c)
    {
        if(c=='a' || c=='e'|| c=='i' || c=='o' || c=='u')
        {    
            return true;
        }    
        else
        {
        return false;
        }    
    }

    public static String findSubstring(String s, int k) {
    // Write your code here
        int max = 0, v = 0;
        String ans = "Not found!";

        for(int i = 0; i < s.length(); i++){
            if(i < k){
                if(isVowel(s.charAt(i))){
                    v++;
                }
            }
            else{
                if(isVowel(s.charAt(i-k))){
                    v--;
                }

                if(isVowel(s.charAt(i))){
                    v++;
                }
            }

            if(i >= k-1 && v > max){
                v = max;
                ans = s.substring(i-k+1, i+1);
            }
        }

        return ans;
    }

}
public class Solution {
