/*
https://www.geeksforgeeks.org/minimum-number-of-manipulations-required-to-make-two-strings-anagram-without-deletion-of-character/
https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int minSteps(String s, String t) {
        return isAnagram(s,t);
    }
    public int isAnagram(String s, String t) {
        int counts[]=new int[26];
        int steps=0;
        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)-'a']++;
            counts[t.charAt(i)-'a']--;
        }
        
        for(int i: counts){
            if(i<0)
            {
                steps=steps-(i);
            }
        }
        return steps;
        
    }
}