class Solution {
    public int projectionArea(int[][] grid) {
        int top = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] > 0) top++;
            }
        }
        int side1 = 0;
        for(int i = 0; i < grid.length; i++){
            int max1 = 0;
            for(int j = 0; j < grid[0].length; j++){
               max1 = Math.max(max1, grid[i][j]);
            }
            side1 += max1;
        }        
        int side2 = 0;
        for(int i = 0; i < grid.length; i++){
            int max2 = 0;
            for(int j = 0; j < grid[0].length; j++){
               max2 = Math.max(max2, grid[j][i]);
            }
            side2 += max2;
        }        
        return top + side1 + side2;
    }
}

//https://leetcode.com/problems/projection-area-of-3d-shapes/
