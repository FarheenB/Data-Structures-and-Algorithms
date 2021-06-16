/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/permutation-with-spaces3627/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    List<String> result=new ArrayList<>();
    List<String> permutation(String S){
        if(S.length()<2){
           return result;
        }        
        solve(S,1,S.charAt(0)+"");
        return result;        
    }
    
    public void solve(String str, int index,String curr){
        if(index==str.length()){
            result.add(curr);
            return;
        }
        solve(str,index+1,curr+" "+str.charAt(index));
        solve(str,index+1,curr+str.charAt(index));
    }
}
