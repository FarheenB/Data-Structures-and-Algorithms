/**
 @author Farheen Bano

 Date 15-07-2021
  
 Reference-
 https://leetcode.com/problems/spiral-matrix/
*/

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
         vector<int> list;        
        int top=0, left=0,bottom=matrix.size(),right=matrix[0].size();
        
        while(top<bottom && left<right){
            for(int i=left;i<right;i++){
                list.push_back(matrix[top][i]);
            }
            top++;
            for(int i=top;i<bottom;i++){
                list.push_back(matrix[i][right-1]);
            }
            right--;
            
            if(top<bottom && left<right){
                for(int i=right-1;i>left-1;i--){
                    list.push_back(matrix[bottom-1][i]);
                }
                bottom--;
                for(int i=bottom-1;i>top-1;i--){
                    list.push_back(matrix[i][left]);
                }
                left++;
            }
            
        }
        return list;
    }
};