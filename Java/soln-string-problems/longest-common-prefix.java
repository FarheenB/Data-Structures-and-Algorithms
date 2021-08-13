/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/longest-common-prefix/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];        
        
        String first=strs[0];
        String prefix="";

        for(int i=0;i<first.length();i++){
            for(int j=1;j<strs.length;j++)
                if(i>=strs[j].length() || first.charAt(i)!=strs[j].charAt(i)){
                    return prefix;
            }
            prefix=prefix+""+first.charAt(i);            
        }
        return prefix;
    }
}