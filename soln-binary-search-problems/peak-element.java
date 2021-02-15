/*
https://www.interviewbit.com/problems/find-a-peak-element/
*/

public class Solution {
    public int solve(int[] nums) {
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
        return nums[start];
    }
}