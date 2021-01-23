/*
https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {

    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (!track(mid, m, n, k)) 
                low = mid+ 1;
            else 
                high = mid;
        }
        return low;
    }
        
    public boolean track(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

}