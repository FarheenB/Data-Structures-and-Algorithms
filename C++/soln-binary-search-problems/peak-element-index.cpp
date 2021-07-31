/**
 @author Farheen Bano

 Date 19-07-2021
  
 References-
 https://practice.geeksforgeeks.org/problems/peak-element/1
 https://leetcode.com/problems/find-peak-element/
*/

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int left=0, right=nums.size()-1;
       while (left < right) {
            int mid = left+(right-left) / 2;
            if (nums[mid] > nums[mid + 1])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
};