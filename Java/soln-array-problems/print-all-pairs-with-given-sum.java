/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/print-all-pairs-with-given-sum/
 https://www.geeksforgeeks.org/count-pairs-with-given-sum/
*/

import java.io.*;
import java.util.*;

class Pair{
    int a;
    int b;
    public Pair(int a, int b){
        this.a=a;
        this.b=b;
    }
}

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
	    ArrayList<Pair> result=solve(arr,k);
	    for(Pair p:result){
	        System.out.println(p.a+","+p.b);
	    }
        return result.size();
    
    }
    public static ArrayList<Pair> solve(int[] arr, int k){
	    ArrayList<Pair> result=new ArrayList<>();
	    HashMap<Integer, Integer> map=new HashMap<>();
	    
		for(int i = 0; i < arr.length; i++) 
	    {
	        // dictionary of rem and count
	        int rem = k - arr[i];
	        if (map.containsKey(rem)) 
	        {
	            int count = map.get(rem);
	            for(int j = 0; j < count; j++)
		        	result.add(new Pair(rem,arr[i]));
	        }
	        int val=1;
	        if (map.containsKey(arr[i]))
	            val+=map.get(arr[i]);
            map.put(arr[i], val);
	        
	    }
	    // System.out.println(map);
	    return result;
	    
	}
}