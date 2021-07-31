/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/next-greater-element-i/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();        
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[nums1.length];
        
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums2[i])               
                stack.pop();
            
            if(stack.isEmpty())
                map.put(nums2[i],-1);
            else
                map.put(nums2[i],stack.peek());
            stack.push(nums2[i]);
        }
        
        for(int i=0;i<nums1.length;i++){
            result[i]=map.get(nums1[i]);
            
        }
        return result;
    }
}  
