/**
 @author Farheen Bano
  
 References-
 https://practice.geeksforgeeks.org/problems/minimum-difference-pair5444/1
 https://leetcode.com/problems/minimum-absolute-difference/
*/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result=new ArrayList<>();
        
        Arrays.sort(arr);
        
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            int diff=Math.abs(arr[i+1]-arr[i]);
            if(diff<min){
                result=new ArrayList<>();
                min=diff;
            }
            if(diff==min){
                ArrayList list=new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                result.add(list);
            }
        }
        return result;
    }
}