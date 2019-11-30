class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }        
        return res;
    }
    
    public int dfs(int[][] grid, int i, int j){
        if(outside(grid, i, j) || grid[i][j] != 1) return 0;
        int temp = 0;
        grid[i][j] = -1;
        for(int k = 0; k < x.length; k++){
            int ro = i + x[k];
            int co = j + y[k];
            temp += dfs(grid, ro, co);
        }
        return 1 + temp; 
    }
    
    int[] x = {0,0,-1,1};
    int[] y = {1,-1,0,0};
    
    public boolean outside(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length ) return true;
        return false;
    }
}
//https://leetcode.com/problems/max-area-of-island/
