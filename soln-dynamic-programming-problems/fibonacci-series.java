/*
 @author Farheen Bano
 
 Fibonacci series
 Given a number find the fibonacci series value for that number
 e.g n = 3 -> 3
     n = 4 -> 5
     n = 5 -> 8
   
 Solution
 Recursively it can be calculated by f(n) = f(n-1) + f(n-2)
 Using DP we do not recalculate f(n-1) and f(n-2)
 
 References- 
 https://leetcode.com/problems/fibonacci-number/
 https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class fibonacci{ 
   static int fib(int n){ 
        int f[] = new int[n+2];
        f[0] = 0; 
        f[1] = 1;           
        for (int i = 2; i <= n; i++)
            f[i] = f[i-1] + f[i-2];  
                     
        return f[n]; 
    } 
} 
