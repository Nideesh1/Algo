class Solution {
    public int surfaceArea(int[][] grid) {
                 //top, right, down, left
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] > 0){
                    res += 2;
                }
                
                for(int k = 0 ; k < x.length; k++){
                    int ro = i + x[k];
                    int co = j + y[k];
                    int t = 0;
                    if(inside(grid,ro,co)){
                        t = grid[ro][co];
                    }
                    
                    res += Math.max(0, grid[i][j] - t);
                }
                
            }
        }
        return res;
    }
    
    public boolean inside(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return false;
        }
        return true;
    }
}

//https://leetcode.com/problems/surface-area-of-3d-shapes/
