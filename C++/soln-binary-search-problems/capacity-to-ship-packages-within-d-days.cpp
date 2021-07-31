/**
 @author Farheen Bano
  
 Date 19-07-2021
 
 Reference-
 https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
*/

class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        if(weights.size()<days)
            return -1;
        int sum=0;
        int maxW=*max_element(weights.begin(),weights.end());
        
        for(int i=0;i<weights.size();i++)
            sum+=weights[i];
        
        int start=maxW;
        int end=sum;
        int result=-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(isValid(weights,weights.size(),days,mid)){
                result=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return result;
    }
    
    bool isValid(vector<int>& weights, int n, int D, int mid_max){
        int days=1;
        int sum=0;
        for(int i=0;i<n;i++){
            
            if(sum+weights[i]>mid_max){
                days++;
                sum=0;
            }
            if(days>D)
                return false;
            sum+=weights[i];    
        }

        return true;
    
    }
};