class O {
    int x ; int y ; 
    int layer;
    public O(int x, int y, int layer){
        this.x = x; this.y = y; this.layer = layer;
    }
}


class Solution {
    public int orangesRotting(int[][] grid) {
        int R = grid.length; int C = grid[0].length;
        //boolean[][] visited = new boolean[R][C];
        Queue<O> q = new ArrayDeque<>();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == 2){
                    q.add(new O(i, j, 0));
                }
            }
        }
        
        int res = 0;
        
        while(!q.isEmpty()){
            O cur = q.poll();

            res = Math.max(res, cur.layer);
            
            for(int k = 0; k < x.length; k++){
                int ro = cur.x + x[k];
                int co = cur.y + y[k];
                
                if(inside(grid, ro, co) && grid[ro][co] == 1) {
                    q.add(new O(ro, co,  cur.layer + 1));
                    grid[ro][co] = 2;                    
                }


            }
            
        }
        
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        
        return res;
    }
    
    int[] x = {0,0,-1,1};
    int[] y = {-1,1,0,0};
    
    public boolean inside(int[][] grid, int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)return  false;
        return true;
    }
}
