class Solution {
    
    int[] x = { 0, -1, 0, 1};
    int[] y = { 1, 0, -1, 0};
    
    public boolean outside(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return true;
        return false;
    }
    int[][] grid;
    //source
    int sr = 0;
    int sc = 0;
    
    //dest
    int dr = 0;
    int dc = 0;
    
    
    int res;
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        int tot0 = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){

                if (grid[i][j] != -1) {
                    tot0++;
                }

                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                } else if (grid[i][j] == 2) {
                    dr = i;
                    dc = j;
                }                        
                
            }
        }
        
        res = 0;
        
        dfs(sr, sc, tot0);
        
        return res;
    }
    
    public void dfs(int r, int c, int tot0){
        tot0--;
        if(tot0 < 0)return;
        if(r == dr && c == dc && tot0 == 0){ res++; return;}
        
        grid[r][c] = 3;
        
        
        for(int k = 0; k < x.length; k++){
            int ro = r + x[k];
            int co = c + y[k];
            if(outside(grid, ro, co)) continue;
            if(grid[ro][co] %2 == 0){
                dfs(ro, co, tot0);
            }
        }
        
        
        grid[r][c] = 0;
    }
}


//https://leetcode.com/problems/unique-paths-iii/solution/
