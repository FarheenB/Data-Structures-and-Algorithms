/*
https://practice.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1
https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] str=s.toCharArray();
	    int i=0;
	    int j=0;
	    int max=Integer.MIN_VALUE;
	    
	    HashMap<Character,Integer> map=new HashMap<>();
	    
	    while(j<str.length){
	        map.put(str[j],map.getOrDefault(str[j],0)+1);
            if(map.get(str[j])==1){
                max=Math.max(max,j-i+1);
	            j++;
	        }  
            else if(map.get(str[j])>1){
                while(map.get(str[j])>1 && i<str.length){
    	            if(map.containsKey(str[i])){
        	            if(map.get(str[i])>0){
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
	    }
	    return max!=Integer.MIN_VALUE?max:0;
	}
}