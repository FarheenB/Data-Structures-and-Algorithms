/*
https://www.geeksforgeeks.org/bubble-sort/
*/

import java.io.*;
import java.util.*;
import java.lang.*;

class BubbleSort {
	void sort(int arr[], int n) { 
		for (int i = 0; i < n - 1; i++) { 
			for (int j = 0; j < n - i - 1; j++) { 
				if (arr[j] > arr[j + 1]) { 
					int temp = arr[j]; 
					arr[j] = arr[j + 1]; 
					arr[j + 1] = temp; 
				} 
			} 
		} 
	} 

	void printArray(int arr[], int size) { 
		for (int i = 0; i < size; i++) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	// Driver program 
	public static void main(String args[]) { 
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 }; 
		int n = arr.length; 
		BubbleSort obj=new BubbleSort();
		obj.sort(arr, n); 
		System.out.println("Sorted array: "); 
		obj.printArray(arr, n); 
	} 
} 
