/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/add-binary/
*/

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Solution {
    public String addBinary(String x, String y) {
        BigInteger a=new BigInteger(x,2);
        BigInteger b=new BigInteger(y,2);
        BigInteger zero=new BigInteger("0",2);

        while(b.compareTo(zero)!=0) {
            BigInteger sum = a.xor(b);
            BigInteger carry = (a.and(b)).shiftLeft(1);
            a = sum;
            b = carry;
        }
        return a.toString(2);
    }
}
