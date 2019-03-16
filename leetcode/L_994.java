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
        boolean[][] visited = new boolean[R][C];
        Queue<O> q = new ArrayDeque<>();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == 2){
                    q.add(new O(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        
        int res = 0;
        
        while(!q.isEmpty()){
            O o = q.poll();

            res = Math.max(res, o.layer);
            
            //up
            if( inside(grid,o.x-1, o.y) && !visited[o.x-1][o.y] &&  grid[o.x-1][o.y] == 1 ){
                q.add(new O(o.x-1,o.y, o.layer + 1));
                grid[o.x-1][o.y] = 2;
                visited[o.x-1][o.y] = true;
            }
            
            //down
            if( inside(grid,o.x+1, o.y) && !visited[o.x+1][o.y] && grid[o.x+1][o.y] == 1 ){
                q.add(new O(o.x+1,o.y, o.layer + 1));
                grid[o.x+1][o.y] = 2;
                visited[o.x+1][o.y] = true;
            }
            
            //left
            if( inside(grid, o.x, o.y-1) && !visited[o.x][o.y-1] && grid[o.x][o.y-1] == 1 ){
                q.add(new O(o.x,o.y-1, o.layer + 1));
                grid[o.x][o.y-1] = 2;
                visited[o.x][o.y-1] = true;
            }
            
            
            //right
            if( inside(grid, o.x, o.y+1) && !visited[o.x][o.y+1] && grid[o.x][o.y+1] == 1 ){
                q.add(new O(o.x,o.y+1, o.layer + 1));
                grid[o.x][o.y+1] = 2;
                visited[o.x][o.y+1] = true;
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
    
    public boolean inside(int[][] grid, int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)return  false;
        return true;
    }
}

//https://leetcode.com/problems/rotting-oranges/
//https://leetcode.com/problems/rotting-oranges/discuss/238730/Java-DFS-with-comments(but-O(n2)
