class Solution {
    
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    boolean[][] vis;
    boolean[][] inBorder;
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length;
        int n = grid[0].length;
        int ori = grid[r0][c0];
        vis = new boolean[m][n];
        inBorder = new boolean[m][n];
        
        for(int i = 1; i < m-1; i++){
            for(int j = 1; j < n-1; j++){
                if(!fourSide(grid, i, j, ori) && grid[i][j] == ori){
                    inBorder[i][j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(inBorder[i][j] + " ");
            }
            System.out.println();
        } 
        
              
        dfs(grid, r0, c0, color, ori);
      
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(inBorder[i][j]){
                    grid[i][j] = ori;
                }
            }
        }         
        
        return grid;
    }
    
    public void dfs(int[][] grid, int i , int j, int color, int ori){
        if(outside(grid,i,j) || vis[i][j] || grid[i][j] != ori ) return;
        if(onBorder(grid, i, j) && grid[i][j] == ori){
            grid[i][j] = color; vis[i][j] = true;
        }
        if(fourSide(grid, i, j, ori) && grid[i][j] == ori){
            grid[i][j] = color; vis[i][j] = true;
        }   
        for(int k = 0; k < x.length; k++){
            int ro = i + x[k];
            int co = j + y[k];   
            dfs(grid, ro, co, color, ori);
        }        
        
    }
    
    public boolean outside(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j <0 || j >= grid[0].length) return true;
        return false;
    }
    public boolean onBorder(int[][] grid, int i, int j){
        if(i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) return true;
        return false;
    }    
    
    //if there is at least one side which is different, return true
    public boolean fourSide(int[][] grid, int i, int j, int col){
        boolean res = false;
        loop:
        for(int k = 0; k < x.length; k++){
            int ro = i + x[k];
            int co = j + y[k];
            if(!outside(grid, ro, co)){
                if(grid[ro][co] != col){
                    res = true; break loop;
                }
            }
        }
        return res;
    }
    
}

//https://leetcode.com/problems/coloring-a-border/
