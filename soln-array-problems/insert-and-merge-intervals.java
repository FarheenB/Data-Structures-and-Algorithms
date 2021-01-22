/*
https://www.interviewbit.com/problems/merge-intervals/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        intervals.add(newInterval);
        if(intervals.size()==1){
            return intervals;
        }
        
        
        Collections.sort(intervals,(pair1, pair2)-> 
        {
            return pair1.start-pair2.start;
        });
        
        int size=intervals.size();
        for(int i=1;i<size;i++){
            Interval pair1=intervals.get(i-1);
            Interval pair2=intervals.get(i);
            
            if(pair1.end>=pair2.end && pair2.start<=pair1.end){
                intervals.set(i,new Interval(pair1.start,pair1.end));
                intervals.remove(i-1);
                i--;
            }
            else if(pair1.end<=pair2.end && pair1.end>=pair2.start){
                intervals.set(i,new Interval(pair1.start,pair2.end));
                intervals.remove(i-1);
                i--;
            }
            size=intervals.size();
        }
        return intervals;
    }
}
