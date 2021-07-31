/**
 @author Farheen Bano
  
 References-
 https://www.interviewbit.com/problems/median-of-array/
 https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
 https://leetcode.com/problems/median-of-two-sorted-arrays
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int n1=nums1.length;
        int n2=nums2.length;
        
        int low=0,high=n1;
        
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=((n1+n2+1)/2)-mid1;
        
            int l1=mid1==0?Integer.MIN_VALUE:nums1[mid1-1];
            int l2=mid2==0?Integer.MIN_VALUE:nums2[mid2-1];
            int r1=mid1==n1?Integer.MAX_VALUE:nums1[mid1];
            int r2=mid2==n2?Integer.MAX_VALUE:nums2[mid2];

            if(l1>r2){
                high=mid1-1;
            }
            else if(l2>r1){
                low=mid1+1;
            }
            else{
                return (n1+n2)%2==0? (double)((Math.max(l1,l2)+Math.min(r1,r2))/2.0) : (double)Math.max(l1,l2);
            }      
        }
        return 0.0;
    }
}