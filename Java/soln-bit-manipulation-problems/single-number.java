/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/single-number
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i:nums) {
            result=result^i;
        }
        return result;
    }
}
