/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/valid-palindrome/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase().trim().replaceAll(" ","");
        int len=s.length();
        int start=0;
        int end=len-1; char left,right;
        while(start<end)
        {
            left=s.charAt(start);
            right=s.charAt(end);
            if(left==right)
            {
                start++;
                end--;
            }
            else
            {
                if((left<'a' || left>'z') && (left<'0' || left>'9'))
                {
                    start++;
                }
                else if((right<'a' || right>'z') && (right<'0' || right>'9'))
                {
                    end--;
                }
                else
                    return false;
            }
         
       }
       return true;
    }
}
