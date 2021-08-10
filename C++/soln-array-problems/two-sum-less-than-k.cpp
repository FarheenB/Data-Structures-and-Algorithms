/**
 @author Farheen Bano

 Date 09-08-2021
  
 Reference-
 https://leetcode.com/problems/two-sum-less-than-k
*/

/**
 Solution 1: Nested Loops 
 Time Complexity: O(n^2)
*/

class Solution {
public:
    int twoSumLessThanK(vector<int>& nums, int k) {
        int max=-1;
        if(nums.size()<2)
            return max;     
        for(int i=0;i<nums.size();i++){
            for(int j=i+1;j<nums.size();j++){
                int sum=nums[i]+nums[j];
                if(sum<k){
                    max=std::max(max,sum);
                }
                
            }
        }
        return max;
    }
};


/** 
   Solution 1: Sorting Arrays
   Time Complexity: O(nlogn)
*/

class Solution {
public:
    int twoSumLessThanK(vector<int>& nums, int k) {
        int max=-1;
        if(nums.size()<2)
            return max;     
        sort(nums.begin(),nums.end());
        int left=0;
        int right=nums.size()-1;
        while(left>=0 && right<nums.size() && left<right){
            int sum=nums[left]+nums[right];
            if(sum<k){
                left++;
                max=std::max(max,sum);
            }
            else if(sum>=k)
                right--; 
        }
        return max;
    }
};