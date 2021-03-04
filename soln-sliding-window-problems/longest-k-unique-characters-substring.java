/*
https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=1;i<=T;i++){
		    		    String n=sc.nextLine();
		    String input=sc.nextLine();
		    
		    int k=sc.nextInt();
    		System.out.println(longestKUniqueChars(input,k));
		}
	}
	
	
	public static int longestKUniqueChars(String input,  int k){
	    char[] str=input.toCharArray();
	    int i=0;
	    int j=0;
	    int max=Integer.MIN_VALUE;
	    
	    HashMap<Character,Integer> map=new HashMap<>();
	    
	    while(j<str.length){
	        map.put(str[j],map.getOrDefault(str[j],0)+1);
            
	        if(map.size()==k)
                max=Math.max(max,j-i+1);
            
            while(map.size()>k && i<str.length){
                if(map.containsKey(str[i])){
                    map.put(str[i],map.get(str[i])-1);
                    if(map.get(str[i])==0)
                        map.remove(str[i]);
                }
                i++;
            }
            j++;
	    }
	    return max!=Integer.MIN_VALUE?max:-1;
	}
}