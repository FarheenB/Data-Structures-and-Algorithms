/**
 @author Farheen Bano
  
 Date 15-07-2021
 
 Reference-
 https://leetcode.com/problems/peak-index-in-a-mountain-array/
*/

class Solution {
public:
    int peakIndexInMountainArray(vector<int>& arr) {
        int start=0, end=arr.size()-1;
        
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1])
                end=mid;
            else
                start=mid+1;
        }
        return start;
        
    }
};