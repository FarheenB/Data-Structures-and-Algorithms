/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
*/

class Subarray{
    static ArrayList<Integer> subarraySum(int[] nums, int n, int s) {
        ArrayList<Integer> result=new ArrayList<>();
        int i=0;
        int j=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        while(j<nums.length){
            sum+=nums[j];
            if(sum==s){
                result.add(i+1);
                result.add(j+1);
                return result;
            }
            while(sum>s){
                min=Math.min(min,j-i+1);
                sum-=nums[i];
                i++;
                if(sum==s){
                    result.add(i+1);
                    result.add(j+1);
                    return result;
                }
            }
            j++; 
        }
        if(result.size()==0){
            result.add(-1);
        }
        return result;
    }
}
