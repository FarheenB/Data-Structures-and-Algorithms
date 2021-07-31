/**
 @author Farheen Bano

 Date 24-07-2021
  
 Reference-
 https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
*/

class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        vector<vector<int>>dist(n, vector(n, 10001));
        for(int i=0; i<edges.size(); i++) {
            dist[edges[i][0]][edges[i][1]] = edges[i][2];
            dist[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        
        for(int i=0; i<n; i++) {
            dist[i][i] = 0;
        }
        
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        int result, reachableCities = INT_MAX;
        
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            
            if(count <= reachableCities) {
                reachableCities = count;
                result = i;
            }
        }
        
        return result;
    }
};