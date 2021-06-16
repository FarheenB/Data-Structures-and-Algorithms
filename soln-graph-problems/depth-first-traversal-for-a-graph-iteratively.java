/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/*
g : adjacency list of graph
N : number of vertices

return a list containing the DFS traversal of the given graph
*/

class Traversal
{
    static boolean[] visited;
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int n)
    {
        if(g==null)
            return null;
            
        visited=new boolean[n];     
        ArrayList<Integer> dfs_output=new ArrayList<>();
        
        Stack<Integer> stack=new Stack<>();
        int s=0;
        stack.push(s);
        
        while(!stack.isEmpty()){
            s=stack.pop();
            if(!visited[s]){
                visited[s]=true;
                dfs_output.add(s);
            
                ArrayList<Integer> list=g.get(s);
                for(int a=list.size()-1;a>=0;a--){
                    int i=list.get(a);
                    if(!visited[i])
                        stack.push(i);
                }
            }
        }
        return dfs_output;
    }
}

