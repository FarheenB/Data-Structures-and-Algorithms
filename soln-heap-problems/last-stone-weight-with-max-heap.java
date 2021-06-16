/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/last-stone-weight
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int stone:stones){
            maxHeap.add(stone);
        }
        
        while(maxHeap.size()>1){
            int y=maxHeap.remove();
            int x=maxHeap.remove();

            if(x!=y){
                y=y-x;
                maxHeap.add(y);
            }    
        }
        return maxHeap.isEmpty()?0:maxHeap.remove();

    }
}
