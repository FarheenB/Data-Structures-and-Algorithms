/*
https://leetcode.com/problems/binary-number-with-alternating-bits/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        for(int i=0;i<binary.length()-1;i=i+1){
            if(binary.charAt(i)==binary.charAt(i+1))
                return false;
        }
        return true;
    }
}