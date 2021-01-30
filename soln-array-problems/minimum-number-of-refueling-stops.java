/*
https://leetcode.com/problems/minimum-number-of-refueling-stops/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>((a,b)->b-a);
        int result=0;
        int cur_station=startFuel;
        int i=0;
        
        while(cur_station<target)
        {
            while(i<stations.length && stations[i][0]<=cur_station)
                minHeap.add(stations[i++][1]);
            
            if(minHeap.isEmpty())
                return -1;
            
            cur_station=cur_station+minHeap.remove();
            result++;
        }
        return result;
    }
}