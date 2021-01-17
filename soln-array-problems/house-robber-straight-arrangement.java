/*
https://leetcode.com/problems/house-robber/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int rob(int[] num) {
        int prevMax = 0;
        int max = 0;
        for (int x : num) {
            int temp = max;
            max = Math.max(prevMax + x, max);
            prevMax = temp;
        }
        return max;
    }    
}