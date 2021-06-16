/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/sum-of-two-integers/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
