/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
 https://leetcode.com/problems/group-anagrams/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) 
            return new ArrayList();
        Map<String, List> output = new HashMap<String, List>();
        
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!output.containsKey(key)) 
                output.put(key, new ArrayList());
        
            output.get(key).add(s);
        }
        return new ArrayList(output.values());
    }
}
