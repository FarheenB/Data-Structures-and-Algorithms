/*
https://leetcode.com/problems/shortest-way-to-form-string
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int shortestWay(String source, String target) {
        String remaining=target;  
        int count=0;
        while(remaining.length()>0){
            int i=0;
            int j=0;
            StringBuilder subseq=new StringBuilder();
            while(i<source.length() && j<remaining.length()){
                if(remaining.charAt(j)==source.charAt(i)){
                    subseq.append(remaining.charAt(j));
                    j++;                    
                }
                i++;
            }
            
            if(subseq.length()==0)
                return -1;
            remaining=remaining.substring(subseq.length());
            count++;
        }
        return count;
    }
}