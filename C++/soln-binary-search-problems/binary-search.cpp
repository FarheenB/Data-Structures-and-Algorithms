/**
 @author Farheen Bano
  
 Date 19-07-2021
 
 Reference-
 https://www.geeksforgeeks.org/binary-search/
*/

class Solution {
public:
    int search(vector<int>& nums, int target) {
        return binarySearch(nums,0,nums.size()-1,target);
    }
    
    int binarySearch(vector<int> &nums, int start, int end, int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==nums[mid])
                return mid;
            else if(target<nums[mid])
                end=mid-1;
            else
                start=mid+1;

        }
        return -1;
    }
};