/*
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/immediate-smaller-element1142/1
*/

class Solution {
    void immediateSmaller(int nums[], int n) {
        
        for(int i=0;i<=nums.length-2;i++){
            if(nums[i+1]<nums[i]){
                nums[i]=nums[i+1];
            }
            else
                nums[i]=-1;
        }
        nums[nums.length-1]=-1;
    }
}
