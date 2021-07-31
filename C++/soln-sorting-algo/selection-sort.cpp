/**
 @author Farheen Bano
  
 Date 19-07-2021
 
 Reference-
 https://practice.geeksforgeeks.org/problems/selection-sort/1
*/

// { Driver Code Starts
#include <stdio.h>
 
void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}


 // } Driver Code Ends
class Solution
{
    public:
    void selectionSort(int arr[], int n)
    {
       for (int i = 0; i < n-1; i++) { 
			int small = i; 
			for (int j = i+1; j < n; j++) 
				if (arr[j] < arr[small]) 
					small = j; 

			swap(&arr[small],&arr[i]); 
		} 
    }
};

// { Driver Code Starts.
 
/* Function to print an array */
void printArray(int arr[], int size)
{
    int i;
    for (i=0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}
 
// Driver program to test above functions
int main()
{
    int arr[1000],n,T,i;
  
    scanf("%d",&T);
    
    while(T--){
        
    scanf("%d",&n);
    
    for(i=0;i<n;i++)
      scanf("%d",&arr[i]);
      
    Solution ob;  
    ob.selectionSort(arr, n);
    printArray(arr, n);
    }
    return 0;
}  // } Driver Code Ends