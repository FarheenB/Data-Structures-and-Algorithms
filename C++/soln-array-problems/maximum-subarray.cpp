/**
 @author Farheen Bano
  
 Date 11-08-2021
  
 Reference-
 https://leetcode.com/problems/maximum-subarray/
 Kadane's Algorithm
*/

class Solution {
public:
    int maxSubArray(vector<int>& a) {
        int size=a.size();
        int max_sum = INT_MIN;
        int cur_sum = 0; 
  
        for (int i = 0; i < size; i++){ 
            cur_sum=max(a[i],cur_sum+a[i]);  
            max_sum=max(max_sum, cur_sum); 
            
        }     
        return max_sum;    
    }
};