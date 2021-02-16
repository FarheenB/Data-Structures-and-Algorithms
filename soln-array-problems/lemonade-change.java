/*
https://leetcode.com/problems/lemonade-change/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] quants=new int[3];
        
        if(bills[0]>5)
            return false;
        
        int change=0;
        for(int i=0;i<bills.length;i++){           

            if(bills[i]==5){
                quants[0]++;
            }
            else if(bills[i]==10){
                if(quants[0]>0){
                    quants[0]--;
                    quants[1]++;
                }
                else
                    return false;
            }            
            else if(bills[i]==20){
                if(quants[0]>0 && quants[1]>0){
                    quants[0]--;
                    quants[1]--;
                    quants[2]++;
                }               
                else if(quants[0]>=3){
                    quants[0]-=3;
                    quants[2]++;
                }
                else
                    return false;
            }
        }
        return true;
    }
}