/*
https://leetcode.com/problems/keys-and-rooms
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    HashSet<Integer> visited=new HashSet<>(); 
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        dfs(rooms,0);
        return visited.size()==rooms.size();
    }
    
    public void dfs(List<List<Integer>> rooms,int i){
        visited.add(i);
        for(int keys:rooms.get(i)){
            if(!visited.contains(keys))
                dfs(rooms,keys);            
        }        
    }
}