/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/program-display-number-characters-longest-word-sentence/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {	
	public static int longestWordLength(String str){
	    String[] arr=str.split(" ");
	    int max=0;
	    for(String s:arr){
	        max=Math.max(max,s.length());
	    }
	    return max;
	}
}
