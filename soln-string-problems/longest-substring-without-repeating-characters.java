/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); 
        
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
