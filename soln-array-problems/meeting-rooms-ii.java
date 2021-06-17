/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/meeting-rooms-ii/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Interval{
    int start;
    int end;
    Interval(int start, int end){
        this.start=start;
        this.end=end;
    }
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length==0)
            return 0;
        
        Interval[] schedule=new Interval[intervals.length];
        for(int i=0;i<intervals.length;i++){
            schedule[i]=new Interval(intervals[i][0],intervals[i][1]);
        }
        
        Arrays.sort(schedule, (a,b)->a.start-b.start);
        PriorityQueue<Interval> minHeap=new PriorityQueue<>((a,b)->a.end-b.end);
        
        minHeap.add(schedule[0]);
        for(int i=1;i<intervals.length;i++){
            Interval earliest=minHeap.remove();
            if(schedule[i].start>=earliest.end)
                earliest.end=schedule[i].end;
            else
                minHeap.add(schedule[i]);
            minHeap.add(earliest);
        }
        return minHeap.size();
    }
}