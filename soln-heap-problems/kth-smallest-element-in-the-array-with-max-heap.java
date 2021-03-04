/*
https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
https://www.interviewbit.com/problems/kth-smallest-element-in-the-array/
*/

public class Solution {
    public int kthsmallest(final int[] A, int k) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(k,Collections.reverseOrder());
        int i=0;
        while(i<A.length){
            maxHeap.offer(A[i]);
            if(maxHeap.size()>k)
                maxHeap.poll();
            i++;
        }
        return maxHeap.peek();        
    }
}
