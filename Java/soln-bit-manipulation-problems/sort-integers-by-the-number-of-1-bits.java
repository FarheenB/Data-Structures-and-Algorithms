/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int[] sortByBits(int[] arr) {        
        List<Integer> list=new ArrayList<>();
        
        for(int i:arr)
            list.add(i);
        
        Collections.sort(list,(a, b)-> Integer.bitCount(a)==Integer.bitCount(b)?a-b:Integer.bitCount(a)-Integer.bitCount(b));

        for(int i=0;i<list.size();i++)
            arr[i]=list.get(i);
                        
        return arr;
    }
}
