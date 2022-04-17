class Solution {
    
    int[] x = {0,0,-1,1};
    int[] y = {-1,1,0,0};
    
    public boolean outside(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return true;
        return false;
    }
    
    public int getMaximumGold(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfs(i,j,grid, vis));
            }
        }
        return max;
    }
    public int dfs(int i,int j, int[][] grid, boolean[][] vis) {
        if (outside(i,j,grid) || grid[i][j] == 0 || vis[i][j]) return 0;
        vis[i][j] = true;
        //System.out.println("i " + i + " j " + j);
        int res = 0;
        for (int k = 0; k < x.length; k++) {
            int ro = i + x[k];
            int co = j + y[k];
            res = Math.max(res, dfs(ro,co,grid,vis));
        }
        
        vis[i][j] = false;
        return res + grid[i][j];
    }
}
