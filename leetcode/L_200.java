class Solution {
    
   
    
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){ 
                    res++;
                dfs(grid, i, j);
                }
                 
            }   
        }
        return res;
    }
    
    public void dfs(char[][] grid, int i , int j){
        if(out(grid,i,j)) return;
        if(grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        dfs(grid, i , j+1);
        dfs(grid, i, j -1);
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        
    }
    
    public boolean out(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)return true;
        
        return false;
    }
}

//https://leetcode.com/problems/number-of-islands/
