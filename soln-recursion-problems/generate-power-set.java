/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/power-set4302/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    List<String> result=new ArrayList<>();
    public List<String> AllPossibleStrings(String s){
        powerSet(s,0,"");
        result.remove(result.size()-1);
        Collections.sort(result);
        return result;
    }
    
	void powerSet(String str, int index, String curr){ 
		if(index == str.length()){ 
			result.add(curr);
			return; 
		} 
		powerSet(str, index + 1, curr + str.charAt(index)); 
		powerSet(str, index + 1, curr);
	} 
}
