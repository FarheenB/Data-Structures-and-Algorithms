/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/number-of-1-bits/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
