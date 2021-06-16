/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/print-longest-substring-without-repeating-characters/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    String longestUniqueSubsttr(String s){
        char[] str=s.toCharArray();
	    int i=0;
	    int j=0;
	    int max=Integer.MIN_VALUE;
	    
	    HashMap<Character,Integer> map=new HashMap<>();
	    String result="";
	    while(j<str.length){
	        map.put(str[j],map.getOrDefault(str[j],0)+1);
            if(map.get(str[j])==1){
                if(max<j-i+1){
                    max=j-i+1;
                    result=s.substring(i,j+1);                   
                }
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
	return result;
    }
}
