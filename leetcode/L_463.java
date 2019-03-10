class Solution {
    int res = 0;
    public int islandPerimeter(int[][] grid) {
        if (grid == null) return 0;
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length ; j++){
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    
    public void dfs(int[][]grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ){
            res++; return;
        }
        
        if(grid[i][j]== 0){
            res++; return;
        }
        
        if(grid[i][j] == -1){
            return;
        }
        
        if(grid[i][j] == 1){
            grid[i][j] = -1;
        }
        
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j); 
        dfs(grid, i-1, j);        
        
    }
    
    
}
//https://leetcode.com/problems/island-perimeter/
