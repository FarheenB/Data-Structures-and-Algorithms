/**
 @author Farheen Bano

 Date 15-07-2021
  
 References- 
 https://www.interviewbit.com/problems/container-with-most-water/
 https://leetcode.com/problems/container-with-most-water/
*/

class Solution {
public:
    int maxArea(vector<int>& height) {
        int maxArea=0;
        int left=0;
        int right=height.size()-1;
        while(left<right){
            int b=min(height[left],height[right]);
            int l=right-left;
            int area=l*b;
            maxArea=max(maxArea,area);
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
};