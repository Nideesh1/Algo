class Solution {
    
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    
    public boolean inside(int m, int n, int i , int j ){
        if(i >= 0 && i < m && j >= 0 && j < n) return true;
        return false;
    }
    
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        int[][] distance = new int[m][n];
        
        Queue<Cell> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    distance[i][j] = Integer.MAX_VALUE;
                }
                if(matrix[i][j] == 0){
                    q.add(new Cell(i, j));
                }
            }
        }
        
        while(!q.isEmpty()){
            Cell c = q.poll();
            
            for(int i = 0; i < x.length; i++){
                int ro = c.x + x[i]; int co = c.y + y[i];
                if(inside(m, n, ro, co)){
                    
                    if(distance[ro][co] > distance[c.x][c.y] + 1){
                        distance[ro][co] = distance[c.x][c.y] + 1;
                        q.add(new Cell(ro, co));
                    }
                    
                }
            }
        }
        
        
        return distance;
    }
}

class Cell{
    int x; int y; Cell(int x, int y) {this.x = x; this.y = y;}
}

//https://leetcode.com/problems/01-matrix/
