/*
https://leetcode.com/problems/longest-common-prefix/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0)
            return "";
        String first=strs[0];
        String prefix="";
        int flag=0;
        for(int a=0;a<first.length();a++){
            int count=0;
            for(int i=1;i<strs.length;i++){
                if(a<strs[i].length() && first.charAt(a)==strs[i].charAt(a)){
                    count++;
                }
                else{
                    flag++;
                    break;
                }
            }
            if(flag>0)
                break;
            if(count==strs.length-1){
                prefix=prefix+""+first.charAt(a);            
            }
        }
        return prefix;
    }
}