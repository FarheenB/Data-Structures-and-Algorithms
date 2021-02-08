/*
https://www.interviewbit.com/problems/order-of-people-heights/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public int[] order(int[] heights, int[] infront) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        int n = heights.length;
        for(int i=0; i<n; i++){
            map.put(heights[i],infront[i]);
        }
        
        int res[] = new int[n];
        Arrays.fill(res,-1);
        
        while(map.size()!=0){
            int key = map.firstKey();
            int value = map.get(key);
            
            int count = 0;
            for(int j=0; j<n; j++){
                if(res[j]==-1){
                    count++;
                }
                if(count-1==value){
                    res[j] = key; 
                    break;
                }
            }
            map.remove(key);
        }
        return res;
    }
}