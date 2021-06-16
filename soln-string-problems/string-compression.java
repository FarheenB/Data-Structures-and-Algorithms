/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/string-compression
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int compress(char[] chars) {
        int i=0;
        int index=0;
        while(i<chars.length){
            int j=i;
            while(j<chars.length && chars[i]==chars[j]){
                j++;
            }
            
            chars[index++]=chars[i];
            if(j-i>1){
                String count=j-i+"";
                for(char ch:count.toCharArray()){
                    chars[index++]=ch;
                }
            }
            i=j;
        }
        return index;
    }
}
