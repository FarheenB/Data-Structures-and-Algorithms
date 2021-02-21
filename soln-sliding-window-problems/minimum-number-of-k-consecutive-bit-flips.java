/*
https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int minKBitFlips(int[] A, int K) {
        int i=0;
        int n = A.length;
        int index;
        int count = 0;
        while(i < n) {
            if (A[i] == 0) {
                index = i;
                while (index < i + K) {
                    if (index < A.length) {
                        A[index] ^= 1;
                    }
                    index++;
                }
                if (index > A.length) {
                    return -1;
                }
                count++;
            }
            i++;
        }
        return count;
    }
}