/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/minimum-score-triangulation-of-polygon/

 NOTE: Variation of Matrix Chain Multiplicaton Problem
*/

class Solution {
    public int minScoreTriangulation(int[] num) {
        int t[][]=new int[num.length+1][num.length+1];
    
        for(int[] l:t)
            Arrays.fill(l,-1);
    
        return solve(num,1,num.length-1,t);
    }
   
    static int solve(int[] num, int i, int j, int t[][]){
        if(i>=j)
            return 0;
        
        if(t[i][j]!=-1)
            return t[i][j];
        
        int min=Integer.MAX_VALUE;
        int left,right;
        for(int k=i;k<j;k++){
            if(t[i][k]!=-1)
                left= t[i][k];
            else
            {
                left=solve(num,i,k,t);
                t[i][k]=left;
            }
            
            if(t[k+1][j]!=-1)
                right=t[k+1][j];
            else
            {
                right=solve(num,k+1,j,t);
                t[k+1][j]=right;
            }
            
            int temp=left+right+num[i-1]*num[k]*num[j];
            min=Math.min(min,temp);
        }
        t[i][j]=min;
        return t[i][j];        
    }
}
