/*
https://leetcode.com/problems/partition-labels/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        
        for (int i = 0; i < S.length(); ++i)
            lastIndex[S.charAt(i) - 'a'] = i;
        
        int j = 0, limit = 0;
        List<Integer> ans = new ArrayList();
        
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, lastIndex[S.charAt(i) - 'a']);
            
            //check whether the last occurance of a character is reached
            if (i == j) {
                ans.add(i - limit + 1);
                limit = i + 1;
            }
        }
        return ans;
    }
}