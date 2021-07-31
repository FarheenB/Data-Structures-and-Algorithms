/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/the-stock-span-problem/

 NOTE: Variation of Nearest Greater to the left
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Pair{
    int value;
    int index;
    
    public Pair(int value, int index){
        this.value=value;
        this.index=index;
    }
}
class solve{
    
    // Function to calculate span
    // price[]: input array
    public static int[] calculateSpan(int price[], int n)
    { 
        int[] output=new int[n];
        int[] indices=prevGreater(price);
        for(int i=0;i<n;i++){
            indices[i]=i-indices[i];
        }
        return indices;
    }
        
    public static int[] prevGreater(int[] nums) {
        int[] indices=new int[nums.length];
        //for storing the indicies
        Stack<Pair> stack=new Stack<>();
        
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && stack.peek().value<=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                indices[i]=-1;
            else
                indices[i]=stack.peek().index;
            stack.push(new Pair(nums[i],i));             
        }
        return indices;
    }
}