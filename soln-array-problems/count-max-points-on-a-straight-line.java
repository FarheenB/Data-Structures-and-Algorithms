/*
https://www.geeksforgeeks.org/count-maximum-points-on-same-line/
https://www.interviewbit.com/problems/points-on-the-straight-line/
https://leetcode.com/problems/max-points-on-a-line/

NOTE: slope between two points is given by (y2 – y1) / (x2 – x1).
*/

class Solution {
    public int maxPoints(int[][] points) {
        if(points.length<2)
            return points.length;
        
        int max=0;
        
        for(int i=0;i<points.length;i++){
            int samePoint=1;    
            int localMax=0;
            
            HashMap<String,Integer> map=new HashMap<>();

            for(int j=i+1;j<points.length;j++){
                int dx=points[i][0]-points[j][0];
                int dy=points[i][1]-points[j][1];
                if(dx==0 && dy==0) {
                    samePoint++;
                    continue;
                }
                
                int gcd = gcd(dx, dy);
                // reducing the difference by their gcd 
                dx/=gcd;
                dy/=gcd;
                String slope=dx+"_"+dy;
                
                map.put(slope,map.getOrDefault(slope,0)+1);
                localMax=Math.max(localMax,map.get(slope));    
            }
            max=Math.max(max,localMax+samePoint);
        }
        return max;
    }
    
    private int gcd(int a, int b) {
        if(b == 0) 
            return a;
        return gcd(b, a%b);
    }
}