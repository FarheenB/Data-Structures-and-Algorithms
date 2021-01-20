/*
https://leetcode.com/problems/gas-station/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int total_tank = 0;
        int curr_tank = 0;
        int start_station = 0;
        for (int i = 0; i < n; ++i) {
            int difference=gas[i] - cost[i];
            total_tank += difference;
            curr_tank += difference;
            
            if (curr_tank < 0) {
                start_station = i + 1;
                curr_tank = 0;
            }
        }
        //if the tank total is positive then there is a solution 
        return total_tank >= 0 ? start_station : -1;
    }
}