/*
https://www.geeksforgeeks.org/allocate-minimum-number-pages/
https://www.interviewbit.com/problems/allocate-books/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int books(int[] books, int S) {
       if(books.length<S)
            return -1;
        int sum=0;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<books.length;i++){
            max=Math.max(max,books[i]);
            sum+=books[i];
        }
        int start=max;
        int end=sum;
        int result=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(isValid(books,books.length,S,mid)){
                result=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return result;
    }
    
    public boolean isValid(int[] books, int n, int S, int mid_max){
        int student=1;
        int sum=0;
        for(int i=0;i<n;i++){
            
            if(sum+books[i]>mid_max){
                student++;
                sum=0;
            }
            if(student>S)
                return false;
            sum+=books[i];    
        }

        return true;
    }
}