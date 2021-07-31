/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/minimum-window-subsequence/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String minWindow(String S, String T) {
        int j=0;
        int end=0;
        int min=Integer.MAX_VALUE;
        String subsq="";
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)==T.charAt(j)){
                j++;
            
                if(j==T.length()){
                    end=i;
                    j--;
                    while(j>=0){
                        if(S.charAt(i)==T.charAt(j)){
                            j--;
                        }
                        i--;
                    }
                    j++;
                    i++;
                    if(min>(end-i+1)){
                        min=end-i+1;
                        subsq=S.substring(i,end+1);
                    }
                }
            }
        }
        return subsq;
    }
}
