/*
https://www.geeksforgeeks.org/smallest-alphabet-greater-than-a-given-character/
https://leetcode.com/problems/find-smallest-letter-greater-than-target/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;
        return binarySearch(letters,0,n-1,target);
    }
    
    public static char binarySearch(char[] letters, int start, int end, char target){ 
        int flag=0;
        int pos=-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(target==letters[mid]){
                flag++;
                pos=mid;   
                start=mid+1;
            }
            else if(target<letters[mid])
                end=mid-1;
            else
                start=mid+1;
        }
        if(flag>0){
            return letters[(pos+1)%letters.length];
        }
        return letters[start%letters.length];
    }
}
