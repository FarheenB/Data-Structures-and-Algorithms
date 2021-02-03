/*
https://leetcode.com/problems/longest-turbulent-subarray/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int left = 0;
        int max = 1;

        for(int i = 1; i < arr.length; i++) {
            if(i % 2 == 0) {
                if(arr[i] > arr[i-1]) {
                    max = Math.max(max, i - left + 1);
                } 
                else {
                    left = i;
                }
            } 
            else {
                if(arr[i] < arr[i-1]) {
                    max = Math.max(max, i - left + 1);
                } 
                else {
                    left = i;
                }
            }
        }

        left = 0;

        for(int i = 1; i < arr.length; i++) {
            if(i % 2 == 0) {
                if(arr[i] < arr[i-1]) {
                    max = Math.max(max, i - left + 1);
                } 
                else {
                    left = i;
                }
            } 
            else {
                if(arr[i] > arr[i-1]) {
                    max = Math.max(max, i - left + 1);
                } 
                else {
                    left = i;
                }
            }
        }
        return max;
    }
}