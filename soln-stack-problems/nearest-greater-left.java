/**
 @author Farheen Bano 
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
       public static int[] prevGreater(int[] nums) {
        int[] output=new int[nums.length];
        //for storing the indicies
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                output[i]=-1;
            else
                output[i]=nums[stack.peek()];
            stack.push(i);             
        }
        return output;
    }
}
