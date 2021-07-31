/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/flip-game
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> states=new ArrayList<>();
        if(s==null || s.length()==0)
            return states;
        
        int i=0;
        while(i<s.length()){
            int index=s.indexOf("++",i);
            if(index==-1)
                return states;
            
            String newState=s.substring(0,index)+"--"+s.substring(index+2);
            states.add(newState);
            i=index+1;
        }
        return states;
    }
}
