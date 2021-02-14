/*
https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        return binarySearch(reader,0,1,target);
    }
    
    public int binarySearch(ArrayReader reader, int start, int end, int target){
        int pos=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(reader.get(end)<target){
                start=end;
                end=end*2;
            }
            else{
                if(reader.get(mid)==target)
                    return mid;
                else if(reader.get(mid)>target){
                    end=mid-1;
                }   
                else{
                    start=mid+1;
                }
            }
        }
        return pos;
    }
}