class Solution {
    public boolean valid (int x, int y, int[][] maze) {
        if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) return true;
        return false;
    }
    
    public int[][] dirs = {
        {-1,0},//up
        {1,0}, //down
        {0,-1}, //left
        {0,1} //right
    };
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] vis = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        vis[start[0]][start[1]] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) return true;
            //int x = cur[0], y = cur[1];
            
            for (int[] dir : dirs) {
                int x = cur[0];
                int y = cur[1];
                while (valid(x,y,maze)) {
                    x += dir[0];
                    y += dir[1];
                }
                
                if (!vis[x - dir[0]][y - dir[1]]) {
                    q.add(new int[] {x - dir[0], y - dir[1]});
                    vis[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }
}
