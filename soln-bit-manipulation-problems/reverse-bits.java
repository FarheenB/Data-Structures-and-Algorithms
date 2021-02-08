/*
https://leetcode.com/problems/reverse-bits/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans = ans | (n & 1);
            n >>= 1;
        }
        return ans;
    }
}