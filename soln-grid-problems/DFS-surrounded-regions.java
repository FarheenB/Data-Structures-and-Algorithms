/*
https://leetcode.com/problems/surrounded-regions/
https://www.interviewbit.com/problems/capture-regions-on-board/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public void solve(char[][] board) {

        if(board.length==0){
            return;
        }

        int row = board.length;
        int col = board[0].length;

        // top boundry row-first
        for(int c=0; c<col; c++){
            if(board[0][c]=='O')
                markBoundryZero(board, 0, c);
        }

        // right boundry column-last
        for(int r=0; r<row; r++){
            if(board[r][col-1]=='O')
                 markBoundryZero(board, r, col-1);
        }

        // bottom boundry row-last
        for(int c=0; c<col; c++){
            if(board[row-1][c]=='O')
                markBoundryZero(board, row-1, c);
        }

        // left boundry column-firsty
        for(int r=0; r<row; r++){
            if(board[r][0]=='O')
                markBoundryZero(board, r, 0);
        }

        // now convert closed zero into 'X' and 'B' to 'O'
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }
                else if(board[r][c]=='G'){
                    board[r][c]='O';
                } 
            }
        }
    }

    public void markBoundryZero(char[][] board, int i, int j){
        if(i<0||i>=board.length||j<0||j>=board[i].length){
            return;
        }

        if(board[i][j]=='O'){
            //G denoting gap
            //look for all the gaps that can be tranversed from any one gap on the outer boundary
            board[i][j]='G'; 

            markBoundryZero(board, i, j-1);
            markBoundryZero(board, i, j+1);
            markBoundryZero(board, i-1, j);
            markBoundryZero(board, i+1, j);
        }
    }
}