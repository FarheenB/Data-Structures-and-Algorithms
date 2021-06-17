/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/decompress-run-length-encoded-list/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] decompressRLElist(int[] nums) {
        int j=0;
        int freq=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i%2==0)
                freq=nums[i];
            else{
                while(freq!=0 && j<nums.length){
                    list.add(nums[i]);
                    freq--;
                }
            }
        }
        int[] output=new int[list.size()];

        for(int i=0;i<list.size();i++){
            output[i]=list.get(i);
        }
        return output;
    }
}
