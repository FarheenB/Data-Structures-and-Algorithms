/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    ArrayList<String> result=new ArrayList<>();
    ArrayList<String> NBitBinary(int N) {
        solve(N,0,0,"");
        return result;
    }
    
    public void solve(int N, int ones, int zeros, String curr){
        if(N==0){
            result.add(curr);
            return;
        }
        solve(N-1,ones+1,zeros,curr+"1");
        if(ones>zeros)
            solve(N-1,ones,zeros+1,curr+"0");
    }
}
