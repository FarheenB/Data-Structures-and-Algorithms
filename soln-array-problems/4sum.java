/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/4-sum/
 https://leetcode.com/problems/4sum
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result=new HashSet<>();
        if(nums.length<4)
            return new ArrayList<>(result);
        
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    int sum=nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        List<Integer> list=Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        result.add(list);       
                    }
                    if(sum<=target)
                        k++;
                    else
                        l--;                        
                }
            }
        }
        return new ArrayList<>(result);
    }
}
