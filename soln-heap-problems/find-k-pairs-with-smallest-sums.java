/*
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result=new ArrayList<>();
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>(k, (a,b)->a[0]-b[0]);
        
        int i1=0;
        int i2=0;
        while(i1<nums1.length && i2<nums2.length && result.size()<k){
            if(nums1[i1]<nums2[i2]){
                for(int i=i2;i<nums2.length;i++){
                    int diff=nums1[i1]+nums2[i];
                    maxHeap.add(new int[]{diff,i1,i});
                }
                i1++;
            }
            else{
                for(int i=i1;i<nums1.length;i++){
                    int diff=nums1[i]+nums2[i2];
                    maxHeap.add(new int[]{diff,i,i2});   
                } 
                i2++;
            }
            List<Integer> list=new ArrayList<>();
            int[] arr=maxHeap.poll();
            list.add(nums1[arr[1]]);
            list.add(nums2[arr[2]]);
            result.add(list);
        }
        
        int i=0;
        while(result.size()<k && !maxHeap.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int[] arr=maxHeap.poll();
            list.add(nums1[arr[1]]);
            list.add(nums2[arr[2]]);

            result.add(list);
        }
        return result;
    }
}