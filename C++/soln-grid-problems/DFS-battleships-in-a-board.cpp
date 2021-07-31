/**
 @author Farheen Bano

 Date 24-07-2021
  
 Reference-
 https://leetcode.com/problems/battleships-in-a-board/
*/

class Solution {
public:
    int countBattleships(vector<vector<char>>& board) {
        int count=0;
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[0].size();j++){
                if(board[i][j]=='X'){
                    count++;
                    dfs(board, i,j);
                }
            }
        }
        return count;
    }
        
    void dfs(vector<vector<char>>& board, int i, int j){
        if(i<0 || i>=board.size() || j<0 || j>=board[0].size() || board[i][j]=='.')
            return;
        board[i][j]='.';

        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
};