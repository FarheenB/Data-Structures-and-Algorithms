/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/sum-of-subarray-minimums
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int sumSubarrayMins(int[] A) {
        long count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= A.length; i++) {
            while(!stack.isEmpty() && (i == A.length || A[stack.peek()] > A[i])) {
                int mid = stack.pop();
                int left_elems = mid - (stack.isEmpty() ? -1 : stack.peek());
                int right_elems = i - mid;
                count += (long) A[mid] * left_elems * right_elems;
            }
            stack.push(i);
        }
        return (int) (count % 1_000_000_007);
    }
}
