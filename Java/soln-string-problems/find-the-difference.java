/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/find-the-difference/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public char findTheDifference(String s, String t) {
        int[] ch=new int[26];
        char[] s_arr=s.toCharArray();
        char[] t_arr=t.toCharArray();

        for(int i=0;i<t_arr.length;i++){
            ch[t.charAt(i)-'a']++;
        }

        for(int i=0;i<s_arr.length;i++){
            ch[s.charAt(i)-'a']--;
        }

        char extra=' ';
        for(int i=0;i<26;i++){
            if(ch[i]>0)
                extra=(char)('a'+i);
        }
        return extra;        
    }
}
