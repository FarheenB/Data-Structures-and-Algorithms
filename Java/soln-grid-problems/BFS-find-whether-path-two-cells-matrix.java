/**
 @author Farheen Bano
  
 Reference-
 https://www.geeksforgeeks.org/find-whether-path-two-cells-matrix/
*/

class Solution
{
    public class Coords{
        int x;
        int y;
        Coords(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    
    public boolean is_Possible(int[][] grid)
    {
        int N = grid.length;
        int source_r=-1,source_c=-1;
        int dest_r=-1,dest_c=-1;
        
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(grid[i][j]==1){
                    source_r=i;
                    source_c=j;
                
                }
                if(grid[i][j]==2){
                    dest_r=i;
                    dest_c=j;
                    grid[i][j]=3;
                }
            }
        }
        if(source_r==-1 || source_r==-1 || dest_r==-1 || dest_c==-1)
            return false;
        
        
        // right, bottom, left, top
        int dx[] = { 1, 0, -1, 0 };
        int dy[] = { 0, 1, 0, -1 };
                
        Queue<Coords> queue=new LinkedList<>();
        
        //Enqueue the first coordinate
        queue.add(new Coords(source_r, source_c));
        grid[source_r][source_c] = 0;
        
        while(!queue.isEmpty()) {
            Coords s=queue.remove();
            int distance=grid[s.x][s.y];
            
            if(s.x == dest_r && s.y == dest_c) {
                if(distance>0)
                    return true;
                
            }
                
            grid[s.x][s.y] = 0;
            
            for(int i = 0; i < 4; i++) {
                int x = s.x + dx[i];
                int y = s.y + dy[i];
                if(x < 0 || x >= N || y < 0 || y >= N || grid[x][y]!=3) 
                    continue;
                queue.add(new Coords(x,y));
                grid[x][y]=distance+1;
            }
        }
        return false;
    }
}
