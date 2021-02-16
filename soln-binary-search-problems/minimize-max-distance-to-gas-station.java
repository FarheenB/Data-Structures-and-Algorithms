/*
https://leetcode.com/problems/minimize-max-distance-to-gas-station/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double start=0;
        double end=1e8;
        double result=-1;
        
        while(end-start>1e-6){
            double mid=start+(end-start)/2.0;
            if(isValid(stations,stations.length,k,mid)){
                end=mid;                
            }
            else{
                result=mid;
                start=mid;
            }
        }
        return result;            
    }
    
    public boolean isValid(int[] stations, int n, int k, double mid_max){
        int used=0;
        for(int i=0;i<n-1;i++){
            used+=(int)((stations[i+1]-stations[i])/mid_max);
        }
        return used<=k;
    }
}