/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/single-number-ii/
 https://leetcode.com/problems/single-number-ii
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int singleNumber(int[] nums) {
        int once=0;
        int twice=0;
        for(int n:nums){
            once=once^n & ~twice;
            twice=twice^n & ~once;
        }
        return once;
    }
}
