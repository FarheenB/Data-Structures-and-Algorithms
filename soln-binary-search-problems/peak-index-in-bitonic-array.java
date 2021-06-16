/**
 @author Farheen Bano
  
 References-
 https://www.geeksforgeeks.org/find-element-bitonic-array/
 https://leetcode.com/problems/peak-index-in-a-mountain-array/
*/

class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        return binarySearch(nums,0,nums.length-1);
    }
    
    public int binarySearch(int[] nums, int start, int end){
        while (start < end) {
            int mid = start+(end-start) / 2;
            if (nums[mid] > nums[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
}
