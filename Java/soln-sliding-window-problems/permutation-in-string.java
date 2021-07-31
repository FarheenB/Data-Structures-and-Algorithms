/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/permutation-in-string/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {        
        if(s2.length()<s1.length())
            return false;
                
        int counts_s1[]=new int[26];
        
        for(int ind=0;ind<s1.length();ind++)
            counts_s1[s1.charAt(ind)-'a']++;
        
        int counts_s2[]=new int[26];
        int i=0;
        int j=0;
        int k=s1.length();
    
        while(j<s2.length()){
            counts_s2[s2.charAt(j)-'a']++;
 
            if((j-i+1)==k){
                if(match(counts_s2,counts_s1))
                    return true;
                counts_s2[s2.charAt(i)-'a']--;
                i++;              
            }
            j++;
        }
        return false;
    }       
    
    public boolean match(int[] count_s2, int[] count_s1){        
        for(int i=0;i<count_s2.length;i++){
            if(count_s2[i]-count_s1[i]!=0)
                return false;
        }
        return true;        
    }
}
