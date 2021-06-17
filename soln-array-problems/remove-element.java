/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/remove-element/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int a:nums){
            if(a!=val){
                nums[i++]=a;
            }
        }
        return i;
    }
}