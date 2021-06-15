/*
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/can-place-flowers/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {        
        if(flowerbed.length==0){
            return false; 
        }
        if(n==0)
            return true;
        if(flowerbed.length==1){
            return (flowerbed[0]==0 && n==1) ?true:false; 
        }
        
        for(int i=0;i<flowerbed.length;i++){
            if(i==0 && flowerbed[i]==0 && flowerbed[i+1]==0 && n>0) {
                flowerbed[i]=1;
                n--;
            }                   
            else if(i==flowerbed.length-1 && flowerbed[i]==0 && flowerbed[i-1]==0 && n>0) {
                flowerbed[i]=1;
                n--;
            }
            else if(i>0 && i<flowerbed.length-1 && flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0 && n>0) {
                flowerbed[i]=1;
                n--;
            }            
        }
        if(n==0){
            return true;
        }
        return false;
    }
}
