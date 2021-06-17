/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/pancake-sorting/
 https://www.geeksforgeeks.org/pancake-sorting/
*/

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result=new ArrayList<>();

        for(int i=arr.length-1;i>0;i--){
            int maxPos=findmax(arr,i);
            if(maxPos!=i){
                flip(arr,maxPos);
                flip(arr,i);                
                result.add(maxPos+1);
                result.add(i+1);
            }
        }        
        return result;
    }
    
    public int findmax(int[] arr, int pos){
        int maxPos=pos;
        for(int i=pos-1;i>=0;i--) {
            if(arr[i]>arr[maxPos])
                maxPos=i;
        }        
        return maxPos;
    }
    
    public void flip(int arr[],int pos){
        for(int i=0; i <= pos/2; i++){
            swap(arr,i,pos-i);
        }
    }
    
    public void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }    
}