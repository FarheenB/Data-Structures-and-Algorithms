/*
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/palindrome-partitioning/
 https://leetcode.com/problems/palindrome-partitioning/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    List<List<String>> list = new ArrayList<>();

    public List<List<String>> partition(String str) {
        int len = str.length();
        
        boolean[][] t = new boolean[len][len];
        
        solve(str, 0, t, new ArrayList<>());
        return list;
    }

   public void solve(String str, int i, boolean[][] t, List<String> currentList) 
   {
       //base condition
       if (i >= str.length())
           list.add(new ArrayList<>(currentList));
       
       for (int j = i; j < str.length(); j++) {
           if (str.charAt(i) == str.charAt(j) && (j - i <= 2 || t[i + 1][j - 1])) {
                t[i][j] = true;
                currentList.add(str.substring(i, j + 1));
                solve(str, j + 1, t, currentList);
               
                currentList.remove(currentList.size() - 1);
           }
       }
    }
}
