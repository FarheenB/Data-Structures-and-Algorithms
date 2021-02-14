/*
https://practice.geeksforgeeks.org/problems/rotation4723/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    int findKRotation(int arr[], int n) {
        if(n==1)
            return 0;
        if(arr[0]<arr[n-1])
            return 0;
        return binarySearch(arr,0,n-1,n);
    }
    
    int binarySearch(int[] arr, int start, int end, int n){
        int pos=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            int next=(mid+1)%n;
            int prev=(mid+n-1)%n;
            pos=mid;
            if(arr[mid]<=arr[prev] && arr[mid]<=arr[next]){
                return mid;
            }
            else if(arr[mid]<arr[end]){
                end=mid-1;
            }
            else
                start=mid+1;
            
        }
        return pos;
        
    }
}