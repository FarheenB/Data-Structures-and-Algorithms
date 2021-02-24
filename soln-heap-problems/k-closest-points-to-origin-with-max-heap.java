/*
https://leetcode.com/problems/k-closest-points-to-origin/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>(K, (a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        
        for(int[] point:points){            
            maxHeap.add(point);
            if(maxHeap.size()>K){
                maxHeap.remove();
            }
        }
        
        int[][] result=new int[maxHeap.size()][2];
        int i=0;
        while(!maxHeap.isEmpty()){
            result[i++]=maxHeap.remove();
        }
        return result;
    }
}