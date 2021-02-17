/*
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/

Note: Variation of longest-k-unique-characters-substring
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] str=s.toCharArray();
	    int i=0;
	    int j=0;
        int k=2;
	    int max=Integer.MIN_VALUE;
	    
	    HashMap<Character,Integer> map=new HashMap<>();
	    
	    while(j<str.length){
	        map.put(str[j],map.getOrDefault(str[j],0)+1);
	        if(map.size()>k){
    	        while(map.size()>k && i<str.length){
    	            if(map.containsKey(str[i])){
        	            if(map.get(str[i])>1){
        	                map.put(str[i],map.get(str[i])-1);
        	            }
        	            else{
        	                map.remove(str[i]);
        	            }
    	            }
    	            i++;
    	        }
    	        j++;
	        }
	        else if(map.size()<=k){
	            max=Math.max(max,j-i+1);
	            j++;
	        }
	    }
	    return max!=Integer.MIN_VALUE?max:0;
	}
}