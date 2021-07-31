/**
 @author Farheen Bano
  
 Date 19-07-2021
 
 Reference-
 https://leetcode.com/problems/pancake-sorting/
 https://www.geeksforgeeks.org/pancake-sorting/
*/

class Solution {
public:
    vector<int> pancakeSort(vector<int>& arr) {
        vector<int> result;
        for(int i=arr.size()-1;i>0;i--){
            int maxPos=findmax(arr,i);
          
            if(maxPos!=i){
                flip(arr,maxPos);
                flip(arr,i);                
                result.push_back(maxPos+1);
                result.push_back(i+1);
            }
        }        
        return result;
    }
    
    int findmax(vector<int>& arr, int pos){
        int maxPos=pos;
        for(int i=pos-1;i>=0;i--) {
            if(arr[i]>arr[maxPos])
                maxPos=i;
        }        
        return maxPos;
    }
    
    void flip(vector<int>& arr,int pos){
        for(int i=0; i <= pos/2; i++){
            swap(arr,i,pos-i);
        }
    }
    
    void swap(vector<int>& arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }    
};