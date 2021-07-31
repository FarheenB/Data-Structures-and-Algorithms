/**
 @author Farheen Bano

 Date 15-07-2021

 Reference-
 https://leetcode.com/problems/search-in-rotated-sorted-array
*/

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int n=nums.size();
        int mI=minIndex(nums,0,n-1,n);
        if(nums[mI]==target)
            return mI;
        else if(target>nums[mI] && target<=nums[n-1])
            return binarySearch(nums,mI+1,n-1,target);
        return binarySearch(nums,0,mI-1,target);
    }
    
    int minIndex(vector<int>& arr, int start, int end, int n){
        int pos=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            int prev=(mid+n-1)%n;
            int next=(mid+1)%n;
            if(arr[mid]<=arr[prev] && arr[mid]<=arr[next]){
                return mid;
            }
            else if(arr[mid]<arr[end])
                end=mid-1;
            else 
                start=mid+1;

        }
        return pos;
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