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


class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    //System.out.println("fd");
                    for (int k = 0; k < 4; k++) {
                        int ro = i + x[k];
                        int co = j + y[k];
                        //System.out.println(ro + "," + co);
                        //System.out.println(ro + "," + co);
                        if (outside(grid, ro, co) || grid[ro][co] == 0) {
                            
                            res += 1;
                        }
                    }
                    
                }
            }
        }
        
        return res;
    }
    
    int[] x = {0,0,-1,1};
    int[] y = {-1,1,0,0};
    
    public boolean outside(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ) return true;
        return false;
    }
}
