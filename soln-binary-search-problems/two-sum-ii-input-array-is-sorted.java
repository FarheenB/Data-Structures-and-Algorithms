/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result=new int[2];
        Arrays.fill(result,-1);
        int i=0;
        int j=numbers.length-1;
        
        while(i<j){
            int sum=numbers[j]+numbers[i];
            if(sum==target){
                result[0]=i+1;
                result[1]=j+1;
                return result;
            }
            else if(sum>target){
                j--;
            }
            else
                i++;
        }
        return result;
    }
}
