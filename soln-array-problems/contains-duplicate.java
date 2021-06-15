/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/contains-duplicate/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;        
    }
}
