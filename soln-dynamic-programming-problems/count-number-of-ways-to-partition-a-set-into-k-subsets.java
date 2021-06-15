/**
 @author Farheen Bano

 Reference- 
 https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution{
	static int countP(int n, int k) {
		int[][] dp = new int[n+1][k+1]; 

		for (int i = 0; i <dp.length; i++) 
		    dp[i][0] = 0; 
		for (int i = 0; i <dp[0].length; i++) 
		    dp[0][k] = 0; 

		for (int i = 1; i <dp.length; i++){
			for (int j = 1; j <dp[0].length; j++) {
				//If there is only one set
				//If the number of elements are same as number of sets
				if (j == 1 || i == j) 
					dp[i][j] = 1; 
				else
					dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];	    	    
			}
		}    		
		return dp[n][k]; 
	} 
}
