/*
https://leetcode.com/problems/single-number-iii
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] singleNumber(int[] nums) {
        int result=0;
        for(int n:nums){
            result=result^n;
        }
        
        int x=0;
        int diff=result & (-result);
        for(int n:nums){
            if((n&diff)!=0){
                x^=n;
            }
        }
        return new int[]{x,result^x};
    }
}