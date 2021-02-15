/*
https://leetcode.com/problems/plus-one/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] plusOne(int[] digits) {
        int i=digits.length-1;
        while(i>=0){
            if(digits[i]<9){                
                digits[i]++;
                return digits;
            }
            digits[i]=0;
            i--;
        }
        int[] result=new int[digits.length+1];
        result[0]=1;
        return result;
    }
}