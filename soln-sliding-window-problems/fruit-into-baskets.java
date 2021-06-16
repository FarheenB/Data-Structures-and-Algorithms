/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/fruit-into-baskets
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int totalFruit(int[] tree) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int max=Integer.MIN_VALUE;
        while(j<tree.length){
            map.put(tree[j],map.getOrDefault(tree[j],0)+1);

            if(map.size()<=2){
                max=Math.max(max,j-i+1);
            }

            while(i<tree.length && map.size()>2){
                if(map.containsKey(tree[i])){
                    map.put(tree[i],map.get(tree[i])-1);
                    if(map.get(tree[i])==0)
                        map.remove(tree[i]);
                }
                i++;               
            }
            j++;           
        }
        return max;
    }
}
