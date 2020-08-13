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


class Solution {
    
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int ori = grid[r0][c0];
        Set<Integer> vis = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length; int n = grid[0].length;
        q.add(new int[]{r0,c0});
        vis.add(r0 * n + c0);
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0]; int c = cur[1];
            
            if(inside(m,n,r,c) && border(m,n,r,c)){grid[r][c] = color;}
            
            for(int k = 0; k < x.length; k++){
                int ro = r + x[k]; int co = c + y[k];
                
                
                if(inside(m,n,ro,co) && !vis.contains(ro*n + co)){
                  // neighbor in CC
                  if(grid[ro][co] == ori){
                      q.add(new int[]{ro,co});
                      vis.add(ro*n + co);
                  // neighbor is not in CC, so this node is on boundary edge
                  }else{
                      grid[r][c] = color;
                  }  
                }
                     
            }
        }
        
        
        return grid;
    }
    
    public boolean inside(int m, int n, int ro, int co){
        if(ro >= m || ro < 0 || co >= n || co < 0) return false;
        return true;
    }
    public boolean border(int m, int n, int ro, int co){
        if(ro == m - 1 || ro == 0 || co == n - 1 || co == 0) return true;
        return false;
    }
}

// Credit https://leetcode.com/problems/coloring-a-border/discuss/283262/JavaPython-3-BFS-and-DFS-codes

class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int m = grid.length; 
        int n = grid[0].length;
        int ori = grid[r0][c0];
        dfs(grid, m, n, r0, c0, color, ori);
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] < 0) grid[i][j] = color;
            }
        }
        
        return grid;
    }
    public void dfs(int[][] grid, int m, int n, int r0, int c0, int color, int ori){
        if(!inbound(m, n, r0, c0) || grid[r0][c0] != ori) return;
        grid[r0][c0] = -1 * grid[r0][c0];
        for(int k = 0; k < x.length; k++){
            int ro = r0 + x[k]; int co = c0 + y[k];
            dfs(grid, m, n, ro, co, color, ori);
        }
        if(isInner(grid,m,n,r0,c0,ori)){
            grid[r0][c0] = -1 * grid[r0][c0];
        }
    }
    
    public boolean isInner(int[][] grid, int m, int n, int r0, int c0, int ori){
        if(r0 >0 && r0 < m - 1 && c0 > 0 && c0 < n - 1 && 
          
            Math.abs(grid[r0 -1 ][c0]) == ori &&
            Math.abs(grid[r0 +1 ][c0]) == ori &&
            Math.abs(grid[r0  ][c0 + 1]) == ori &&
            Math.abs(grid[r0  ][c0 - 1]) == ori
          
          ) {return true;}
        
        return false;
    }
    
    public boolean inbound(int m, int n, int ro, int co){
        if(ro >= m || ro < 0 || co >= n || co < 0) return false;
        return true;
    }

    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};    
}


//Credit https://leetcode.com/problems/coloring-a-border/discuss/282847/C%2B%2B-with-picture-DFS
