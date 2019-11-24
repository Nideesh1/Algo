class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;
        int res = 0;
        Comparator<Cell> com = new Comparator<Cell>(){
            public int compare(Cell c1, Cell c2){
                return c1.height - c2.height;
            }
        };
        
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(com);
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            vis[i][0] = true;
            vis[i][n-1] = true;
            pq.add(new Cell(i, 0, heightMap[i][0]));
            pq.add(new Cell(i, n-1, heightMap[i][n-1]));
        }
        for(int j = 0; j < n; j++){
            vis[0][j] = true;
            vis[m-1][j] = true;
            pq.add(new Cell(0, j, heightMap[0][j]));
            pq.add(new Cell(m-1, j, heightMap[m-1][j]));
        }
        
        int[] x = {0,0,-1,1};
        int[] y = {-1,1,0,0};
        
        while(!pq.isEmpty()){
            Cell c = pq.poll();
            for(int k = 0; k < x.length; k++){
                int ro = x[k] + c.row;
                int co = y[k] + c.col;
                
                if(outside(heightMap, ro, co) || vis[ro][co]) continue;
                    vis[ro][co] = true;
                res += Math.max(0, c.height - heightMap[ro][co]);
                
                
                pq.add(new Cell(ro, co, Math.max(heightMap[ro][co], c.height)));
            }
        }
        return res;
    }
    
    public boolean outside(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)return true;
        return false;
    }
    
    public class Cell {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}

//https://leetcode.com/problems/trapping-rain-water-ii/
//https://leetcode.com/problems/trapping-rain-water-ii/discuss/89461/Java-solution-using-PriorityQueue
