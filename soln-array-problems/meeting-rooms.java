/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/meeting-rooms
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
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length<2)
            return true;
        
        Interval[] schedule=new Interval[intervals.length];
        for(int i=0;i<intervals.length;i++){
            schedule[i]=new Interval(intervals[i][0],intervals[i][1]);
        }
        
        Arrays.sort(schedule, (a,b)->a.start-b.start);
        
        for(int i=1;i<intervals.length;i++){
            if(schedule[i].start<schedule[i-1].end){
                return false;
            }
        }
        return true;
    }
}