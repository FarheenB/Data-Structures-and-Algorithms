/*
https://leetcode.com/problems/valid-palindrome-ii
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        char ch[]=s.toCharArray();
        while(i<j){
            if(ch[i]!=ch[j]){
                return isPalindrome(ch,i+1,j)|| isPalindrome(ch,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome(char ch[], int i, int j){
        while(i<j)
        { 
            if(ch[i]!=ch[j])
                return false;
            i++;
            j--;
            
        }
        return true;
    }
}