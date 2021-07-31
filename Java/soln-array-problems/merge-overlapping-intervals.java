/**
 @author Farheen Bano
  
 Reference-
 https://www.interviewbit.com/problems/merge-overlapping-intervals/
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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals==null || intervals.size()==0){
            return null;
        }
        
        Collections.sort(intervals,(pair1, pair2)-> 
        {
            return pair1.start-pair2.start;
        });
        
        for(int i=0;i<intervals.size()-1;i++){
            Interval pair1=intervals.get(i);
            Interval pair2=intervals.get(i+1);
            if(pair1.end>=pair2.start){
                pair1.start=Math.min(pair1.start, pair2.start);
                pair1.end=Math.max(pair1.end, pair2.end);
                intervals.remove(i+1);
                i--;
            }
        }
        return intervals;
    }
}
