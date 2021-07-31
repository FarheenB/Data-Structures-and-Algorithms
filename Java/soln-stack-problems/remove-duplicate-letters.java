/**
 @author Farheen Bano
  
 References-
 https://leetcode.com/problems/remove-duplicate-letters
 https://leetcode.com/problems/smallest-subsequence-of-distinct-characters
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);

        Stack<Character> stack=new Stack<>(); 
        for(char ch:s.toCharArray()){
            map.put(ch,map.get(ch)-1);            
            if(stack.contains(ch))
                continue;
            
            while(!stack.isEmpty() && stack.peek()>ch && map.get(stack.peek())>0)
                stack.pop();            
            stack.push(ch);
        }
        
        StringBuilder str=new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}
