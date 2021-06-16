/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/most-common-word/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set=new HashSet<>();
        for(String s:banned){
            set.add(s);
        }
        
        HashMap<String,Integer> map=new HashMap<>();
        int max=0;
        String max_word="";
        for(String s: paragraph.replaceAll("[^a-zA-Z]"," ").toLowerCase().split(" ")){

            if(!s.equals("") && !set.contains(s)){
                if(map.containsKey(s))
                    map.put(s,map.get(s)+1);
                else
                    map.put(s,1);
                if(max<map.get(s)){
                    max_word=s;
                    max=map.get(s);
                }
            }
            
        }
        return max_word;
    }
}
