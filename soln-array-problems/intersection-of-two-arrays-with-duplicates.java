/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/intersection-of-two-arrays-ii
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map <Integer, Integer> map = new HashMap<>();
        List <Integer> intersect = new ArrayList<>();
        
        for (int i=0;i<nums1.length;i++)
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        
        for (int i=0;i<nums2.length;i++){
            if (map.containsKey(nums2[i])&&map.get(nums2[i])>0){
                map.put(nums2[i],map.get(nums2[i])-1);
                intersect.add(nums2[i]);
            }                
        }
        
        int[] result = new int[intersect.size()];
        for (int i=0;i<intersect.size();i++){
            result[i]=intersect.get(i);
        }
        return result;
    }
}