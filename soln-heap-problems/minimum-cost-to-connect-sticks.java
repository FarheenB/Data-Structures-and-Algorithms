/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/minimum-cost-to-connect-sticks/
*/

class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        
        int i=0;
        while(i<sticks.length){
            minHeap.add(sticks[i]);
            i++;
        }
        int total=0;
        while(minHeap.size()>1){
            int sum=0;
            for(i=0;i<2;i++){
                sum+=minHeap.poll();
            }
            total+=sum;
            minHeap.add(sum);
        }
        return total;      
        
    }
}
   
