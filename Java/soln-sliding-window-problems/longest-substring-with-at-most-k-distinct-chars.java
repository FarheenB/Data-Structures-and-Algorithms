/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/

 Note: Variation of longest-k-unique-characters-substring
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] str=s.toCharArray();
	    int i=0;
	    int j=0;
	    int max=Integer.MIN_VALUE;
	    
	    HashMap<Character,Integer> map=new HashMap<>();
	    
	    while(j<str.length){
	        map.put(str[j],map.getOrDefault(str[j],0)+1);
            
	        if(map.size()<=k)
                max=Math.max(max,j-i+1);
            
            while(map.size()>k && i<str.length){
                if(map.containsKey(str[i])){
                    map.put(str[i],map.get(str[i])-1);
                    if(map.get(str[i])==0)
                        map.remove(str[i]);
                }
                i++;
            }
            j++;
	    }
	    return max!=Integer.MIN_VALUE?max:0;
	}
}
