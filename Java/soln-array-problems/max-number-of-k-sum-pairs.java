/**
 @author Farheen Bano

 Date 05-08-2021
  
 Reference-
 https://leetcode.com/problems/max-number-of-k-sum-pairs
 Using Maps
*/

class Solution {
    public int maxOperations(int[] nums, int k) {
        if(nums.length<2)
            return 0;
        
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int other=k-nums[i];
            if(map.containsKey(other)){
                count++;
                if(map.get(other)==1)
                    map.remove(other);
                else
                    map.put(other, map.get(other)-1);
            }
            else
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return count; 
    }
}