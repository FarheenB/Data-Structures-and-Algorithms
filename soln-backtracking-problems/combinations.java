/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/combinations/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {     
        List<List<Integer>> result=new ArrayList<>();
        possibleCombination(n,1,k,new ArrayList<>(),result);
        return result;
    }    
    
    public void possibleCombination(int n, int start, int remaining, List<Integer> combination, List<List<Integer>> result){
        if(remaining==0)
            result.add(new ArrayList<>(combination));
        
        else{
            for(int i=start;i<=n-remaining+1;i++){
                if(combination.contains(i))
                    continue;
                combination.add(i);
                possibleCombination(n,i+1,remaining-1,combination,result);
                combination.remove(combination.size()-1);
            }
        }
    }    
}
