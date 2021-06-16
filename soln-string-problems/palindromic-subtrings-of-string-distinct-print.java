/**
 @author Farheen Bano
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static Set<String> set=new HashSet<>();
	public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
	    int T= sc.nextInt();	 
        for(int i=1;i<=T;i++)
        {
            String a= sc.next();
            set=new HashSet<>();
            System.out.println(getPalindromeSubstrs(a));
        }
	}

    
    public static Set<String> getPalindromeSubstrs(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); ++i) {
            // odd-length palindromes, single character center
            getPalindromes(s, i, i);

            // even-length palindromes, consecutive characters center
            getPalindromes(s, i, i + 1);
        }
        return set;
    }

    public static void getPalindromes(String str, int left, int right) {
        int count = 0;

        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right))
                break;   
                
            String palind_str=str.substring(left,right+1);
            if(!set.contains(palind_str)){
                set.add(palind_str);
            }
            
            left--;
            right++;
        }
    }
}
