/**
 @author Farheen Bano
  
 Date 15-07-2021

 References-
 https://www.interviewbit.com/problems/4-sum/
 https://leetcode.com/problems/4sum
*/

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> output_quad;
        
        int len=nums.size();
        int left,right,sum;
        sort(nums.begin(),nums.end());
        
        for(int i=0;i<len-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            
            for(int j=i+1;j<len-2;j++){
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                
                left=j+1, right=len-1;
                while(left<right){
                    sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(target==sum){
                        output_quad.push_back({nums[i],nums[j],nums[left],nums[right]});
                    
                        left++;
                        right--;

                        while(left<right && nums[right]==nums[right+1])
                            right--;
                        while(left<right && nums[left]==nums[left-1])
                            left++;
                    }
                    else if(sum>target){
                        right--;
                    } 
                    else
                        left++;
                }
            }
        }
        return output_quad;
    }
};