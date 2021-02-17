/*
https://practice.geeksforgeeks.org/problems/k-closest-elements3619/1#
https://leetcode.com/problems/find-k-closest-elements/
*/


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair<Integer,Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue()!=a.getValue() ? b.getValue() - a.getValue() : b.getKey() - a.getKey());

        int i=0;
        while(i<arr.length){
            if(maxHeap.size() == k){
                if(Math.abs(arr[i]-x) < maxHeap.peek().getValue()){
                    maxHeap.poll();
                    maxHeap.add(new Pair(i,Math.abs(x-arr[i])));
                } 
            }
            else{
                maxHeap.add(new Pair(i,Math.abs(x-arr[i])));
            }
            i++;
        }
        
        List<Integer> result=new ArrayList<>();
        while(!maxHeap.isEmpty()){
            result.add(arr[maxHeap.remove().getKey()]);
        }
        Collections.sort(result);

        return result;
    }
}