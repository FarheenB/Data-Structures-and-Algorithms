/*
https://leetcode.com/problems/n-th-tribonacci-number/
https://www.geeksforgeeks.org/tribonacci-numbers/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    public int tribonacci(int n) {        
        int f[] = new int[n+2]; 
        int i; 
        f[0] = 0; 
        if(n==0)
            return f[n]; 
        f[1] = 1;
        if(n==1)
            return f[n]; 
        f[2] = 1; 

        for (i = 3; i <= n; i++) 
        { 
            f[i] = f[i-1] + f[i-2]+ f[i-3];; 
        } 

        return f[n]; 
    
    }
}