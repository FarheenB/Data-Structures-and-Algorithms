/*
https://leetcode.com/problems/happy-number
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen=new HashSet<>();
        
        while(n!=1){
            int sum=0;
            while(n!=0){
                sum+=(int)Math.pow((n%10),2);
                n=n/10;
            }
            
            if(seen.contains(sum))
                return false;
            
            seen.add(sum);
            n=sum;
        }
        return true;
    }
}