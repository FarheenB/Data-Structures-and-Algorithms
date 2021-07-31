/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
    int steps=0;
    public void deleteMid(Stack<Integer> s,int sizeOfStack){
        if(s.size()==0)
            return;

        int mid=(sizeOfStack/2)+1;
        solve(s,mid);
    } 
    
    public void solve(Stack<Integer> s, int mid){
        if(mid==1){
            int n=s.pop();
            return;
            
        }
        
        int n=s.pop();
        solve(s,mid-1);            
        s.push(n);
    }
}
