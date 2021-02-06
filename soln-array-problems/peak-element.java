/*
https://www.interviewbit.com/problems/find-a-peak-element/
*/

public class Solution {
    public int solve(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1])
                right = mid;
            else
                left = mid + 1;
        }
        return nums[left];
    }
}
