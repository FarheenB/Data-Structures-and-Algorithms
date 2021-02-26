/*
https://leetcode.com/problems/intersection-of-two-arrays
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {      
        HashSet <Integer> set = new HashSet<>();
        HashSet <Integer> intersect = new HashSet<>();
        for (int i=0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for (int i=0;i<nums2.length;i++){
            if (set.contains(nums2[i])){
                intersect.add(nums2[i]);
            }                
        }
        
        int[] result = new int[intersect.size()];
        int index=0;
        for (int r:intersect){
            result[index++]=r;
        }
        return result;
    }
}