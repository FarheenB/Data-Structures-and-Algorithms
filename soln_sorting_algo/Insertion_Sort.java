/*
https://www.geeksforgeeks.org/insertion-sort/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class InsertionSort { 
	void sort(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 1; i < n; ++i) { 
			int curr = arr[i]; 
			int j = i - 1; 

			while (j >= 0 && arr[j] > curr) { 
				arr[j + 1] = arr[j]; 
				j--; 
			} 
			arr[j + 1] = curr; 
		} 
	} 

	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) 
			System.out.print(arr[i] + " "); 

		System.out.println(); 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		int arr[] = { 12, 11, 13, 5, 6 }; 

		InsertionSort ob = new InsertionSort(); 
		ob.sort(arr); 

		printArray(arr); 
	} 
} 