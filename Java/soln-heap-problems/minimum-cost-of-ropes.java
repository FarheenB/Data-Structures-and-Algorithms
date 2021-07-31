/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
*/

class solve {
    long minCost(long arr[], int n) {
        PriorityQueue<Long> minHeap=new PriorityQueue<>();
        
        int i=0;
        while(i<arr.length){
            minHeap.add(arr[i]);
            i++;
        }
        long total=0;
        while(minHeap.size()>1){
            long sum=0;
            for(i=0;i<2;i++){
                sum+=minHeap.poll();
            }
            total+=sum;
            minHeap.add(sum);
        }
        return total;      
        
    }
}
   
