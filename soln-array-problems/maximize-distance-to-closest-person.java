/**
 @author Farheen Bano
  
 Reference-
 https://leetcode.com/problems/maximize-distance-to-closest-person
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n=seats.length;
        int left_occupied[]=new int[n];
        int right_occupied[]=new int[n];
        
        //Assuming that all the seats are empty initially
        Arrays.fill(left_occupied,n);
        Arrays.fill(right_occupied,n);
        
        for(int i=0;i<n;i++){
            if(seats[i]==1){
                left_occupied[i]=0;
            }
            else if(i>0){
                left_occupied[i]=left_occupied[i-1]+1;
            }
        }

        for(int i=n-1;i>=0;i--){
            if(seats[i]==1){
                right_occupied[i]=0;
            }
            else if(i<n-1){
                right_occupied[i]=right_occupied[i+1]+1;
            }
        }
        
        int max=0;
        for(int i=0;i<n;i++){
            if(seats[i]==0){
                //finding the optimal distance from both sides 
                max=Math.max(max,Math.min(left_occupied[i],right_occupied[i]));
            }
        }
        return max;
    }
}