/*
https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle/0#
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {	
	public static int josephus(int n, int k) { 
	    if (n == 1) 
	    	return 1; 
	    else
	    	return (josephus(n - 1, k) + k-1) % n + 1; 
    } 
}	