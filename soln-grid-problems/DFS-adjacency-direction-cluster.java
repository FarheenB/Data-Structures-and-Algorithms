import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    static int count=1;
	public static void main (String[] args) 
	throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int dir=sc.nextInt();
		int x=sc.nextInt();
		int y=sc.nextInt();
		int[][] matrix=new int[x][y];
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				matrix[i][j]=sc.nextInt();
			}
		}

		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(matrix[i][j]==1){
					count++;
					dfs(matrix,i,j,dir);					
				}
			}
		}
		System.out.println(count-1);		
	}
	
	public static void dfs(int[][] matrix, int i, int j, int dir){
		if(i<0||i>=matrix.length || j<0 ||j>=matrix[i].length || matrix[i][j]!=1){
            return;
        }
        matrix[i][j]=count;
        
        // Horizontal:1 Vertical:2 Diagonal:3 Horizontal_Vertical:4 Horizontal_Vertical_Diagonal:5
        if(dir==1 || dir==4 || dir==5){
			dfs(matrix, i,j-1,dir);
			dfs(matrix, i,j+1,dir);
        }
        if(dir==2 || dir==4 || dir==5){
        	dfs(matrix, i-1,j,dir);
        	dfs(matrix, i+1,j,dir);
        }
        if(dir==3 || dir==5){
        	dfs(matrix,i-1,j-1,dir);
        	dfs(matrix,i-1,j+1,dir);
        	dfs(matrix,i+1,j-1,dir);
        	dfs(matrix,i+1,j+1,dir);
        }
	} 
}