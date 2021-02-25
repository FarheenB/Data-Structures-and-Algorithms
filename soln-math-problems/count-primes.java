/*
https://leetcode.com/problems/count-primes
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int countPrimes(int n) {
        if(n==0 || n==1)
            return 0;
        
        boolean[] primes=new boolean[n];
        for(int i=2;i<n;i++)
            primes[i]=true;
        
        for(int i=2;i*i<n;i++){
            if(primes[i]){
                for(int j=i;j*i<n;j++){
                    primes[i*j]=false;
                }
            }
            
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            if(primes[i]){
                count++;
            }
        }
        return count;
    }
}