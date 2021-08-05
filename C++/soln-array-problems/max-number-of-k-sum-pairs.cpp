/**
 @author Farheen Bano

 Date 05-08-2021
  
 Reference-
 https://leetcode.com/problems/max-number-of-k-sum-pairs
*/

class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
       if(nums.size()<2)
            return 0;
        
        int count=0;
        unordered_map<int,int> map;
        for(int i=0;i<nums.size();i++){
            int other=k-nums[i];
            if(map.find(other)!=map.end()){
                count++;
                if(map[other]==1)
                    map.erase(other);
                else
                    map[other]=map[other]-1;
            }
            else
                map[nums[i]]=map[nums[i]]+1;
        }
        return count;  
    }
};