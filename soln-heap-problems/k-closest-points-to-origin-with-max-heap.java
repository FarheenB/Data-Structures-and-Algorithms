/*
https://leetcode.com/problems/k-closest-points-to-origin/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>(K, (a,b)->b[0]-a[0]);
        
        for(int i=0;i<points.length;i++){
            int dist=(int)(points[i][0]*points[i][0]+points[i][1]*points[i][1]); 
            
            maxHeap.add(new int[]{dist,i});
            if(maxHeap.size()>K){
                maxHeap.remove();
            }
        }
        
        int[][] result=new int[maxHeap.size()][2];
        int i=0;
        while(!maxHeap.isEmpty()){
            result[i++]=points[maxHeap.remove()[1]];
        }
        return result;

    }
}