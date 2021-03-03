/*
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
*/

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] adj_list;

    public int countComponents(int n, int[][] edges) {
        adj_list=new ArrayList[n];
        visited=new boolean[n];
               
       for(int i=0;i<n;i++)
            adj_list[i]=new ArrayList<>();        
        for(int edge[]:edges){
            adj_list[edge[0]].add(edge[1]);
            adj_list[edge[1]].add(edge[0]);
        }
        
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
        return count;
    }    
    
    public static void dfs(int node){
        visited[node]=true;
        for(int adj_node:adj_list[node]){
            if(!visited[adj_node])
                dfs(adj_node);
        }
    }
}