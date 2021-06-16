/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/detect-capital
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean detectCapitalUse(String word) {
        int count=0;
        for(char ch:word.toCharArray()){
            if(Character.isUpperCase(ch))
                count++;
        }
        
        if(count==word.length())
            return true;
        if(count==1 && Character.isUpperCase(word.charAt(0)))
            return true;
        if(count==0)
            return true;
        return false;
    }
}
