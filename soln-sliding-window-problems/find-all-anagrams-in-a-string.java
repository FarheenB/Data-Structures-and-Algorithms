/*
https://www.geeksforgeeks.org/count-occurrences-of-anagrams/
https://leetcode.com/problems/find-all-anagrams-in-a-string/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices=new ArrayList<>();
        
        if(s.length()<p.length())
            return indices;
                
        int counts_p[]=new int[26];
        
        for(int ind=0;ind<p.length();ind++)
            counts_p[p.charAt(ind)-'a']++;
        
        int counts_s[]=new int[26];
        int i=0;
        int j=0;
        //sliding window size
        int k=p.length();
    
        while(j<s.length()){
            counts_s[s.charAt(j)-'a']++;
 
            if((j-i+1)==k){
                if(isAnagram(counts_p,counts_s))
                    indices.add(i);
                counts_s[s.charAt(i)-'a']--;
                i++;              
            }
            j++;
        }
        return indices;
    }       
    
    public boolean isAnagram(int[] count_s, int[] count_p){        
        for(int i=0;i<count_s.length;i++){
            if(count_s[i]-count_p[i]!=0)
                return false;
        }
        return true;        
    }
}