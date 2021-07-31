/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/jump-game/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}