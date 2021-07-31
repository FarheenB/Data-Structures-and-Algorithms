  
/**
 @author Farheen Bano

 Date 24-07-2021   

 References-
 https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 https://leetcode.com/problems/maximal-square/
*/

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int n=matrix.size(),m=matrix[0].size();
        vector<vector<int>> newMatrix(n+1, vector<int>(m+1,0));
        int maxSq=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(matrix[i-1][j-1]=='0')
                    newMatrix[i][j]=0;
                else{
                    newMatrix[i][j]=1+min(
                        min(
                            newMatrix[i][j-1],
                            newMatrix[i-1][j]                            
                        ),
                        newMatrix[i-1][j-1]
                    );
                    maxSq=max(maxSq,newMatrix[i][j]);
                        
                }
            }
        }
        return maxSq*maxSq; 
    }
};