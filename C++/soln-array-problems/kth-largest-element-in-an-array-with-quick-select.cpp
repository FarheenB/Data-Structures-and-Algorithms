/**
 @author Farheen Bano
  
 Date 19-07-2021
 
 Reference-
 https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        return quick_select(nums,0,nums.size()-1,nums.size()-k);
    }
    
    int quick_select(vector<int>& nums,int left, int right, int kth_smallest){  
        if(left==right){
            return nums[left]; 
        }
        
        int pivot_index=partition(nums,left,right);
        if(pivot_index==kth_smallest)
            return nums[pivot_index];
        
        else if(kth_smallest<pivot_index)
            return quick_select(nums,left,pivot_index-1,kth_smallest);
        else
            return quick_select(nums,pivot_index+1,right,kth_smallest);
    }
    
    int partition(vector<int>& nums,int left, int right){
        int pivot_index=right;
        int i=left;
        int j=left;
        
        while(j<=right){
            if(nums[j]<nums[pivot_index]){
                swap(nums,i,j);
                i++;
            }
            j++;
        }
        swap(nums,i,pivot_index);
        return i;
    }
    
    void swap(vector<int>& nums,int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
};