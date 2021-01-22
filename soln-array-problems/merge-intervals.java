/*
https://leetcode.com/problems/merge-intervals/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        
        if (intervals == null || intervals.length == 0) {
            return new int[][] {};
        }
        
        // Sort intervals ascending by start value
        Arrays.sort(intervals, (pair1, pair2) -> {
            return pair1[0] - pair2[0];
        });
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] < end) {
                // Ignore current interval, it is a subset of the previous
                continue;
            }
            
            if (intervals[i][0] > end) {
                res.add(new int[]{ start, end });
                
                start = intervals[i][0];
            }
            
            end = intervals[i][1];
        }
        
        res.add(new int[]{ start, end });
        
        return res.toArray(new int[][] {});
    }
}