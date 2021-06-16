/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/hamming-distance/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
