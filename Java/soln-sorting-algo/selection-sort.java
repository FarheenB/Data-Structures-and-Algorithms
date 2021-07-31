/**
 @author Farheen Bano
  
 Reference-
 https://practice.geeksforgeeks.org/problems/selection-sort/1
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class SelectionSort { 
	void sort(int arr[]) { 
		int n = arr.length; 

		for (int i = 0; i < n-1; i++) { 
			int small = i; 
			for (int j = i+1; j < n; j++) 
				if (arr[j] < arr[small]) 
					small = j; 

			int temp = arr[small]; 
			arr[small] = arr[i]; 
			arr[i] = temp; 
		} 
	} 

	void printArray(int arr[]) { 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	// Driver code to test above 
	public static void main(String args[]) { 
		SelectionSort ob = new SelectionSort(); 
		int arr[] = {64,25,12,22,11}; 
		ob.sort(arr); 
		System.out.println("Sorted array"); 
		ob.printArray(arr); 
	} 
} 
