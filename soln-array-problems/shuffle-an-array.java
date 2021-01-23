/*
https://leetcode.com/problems/shuffle-an-array/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    
    private int[] newArr;
    private int[] original;

    Random rand = new Random();

    public Solution(int[] nums) {
        newArr = nums;
        original = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        newArr = original;
        original = original.clone();
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < newArr.length; i++) {
            swap(i, randRange(i, newArr.length));
        }
        return newArr;
    }
    
    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
    
    private void swap(int i, int j) {
        int temp = newArr[i];
        newArr[i] = newArr[j];
        newArr[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */