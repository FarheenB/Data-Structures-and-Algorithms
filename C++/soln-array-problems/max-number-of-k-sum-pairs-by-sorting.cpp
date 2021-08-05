/**
 @author Farheen Bano

 Date 05-08-2021
  
 Reference-
 https://leetcode.com/problems/max-number-of-k-sum-pairs
 Using Sorting
*/

class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
       if(nums.size()<2)
            return 0;
        sort(nums.begin(),nums.end());
        int count=0;
        int left=0;
        int right=nums.size()-1;
        while(left>=0 && right<nums.size() && left<right){
            int sum=nums[left]+nums[right];
            if(sum<k)
                left++;
            else if(sum>k)
                right--;
            else{
                count++;
                left++;
                right--;
            }
        }
        return count;   
    }
};