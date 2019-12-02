class Solution {
    private void bfs(List<List<Integer>> res, Queue<int[]> queue, 
                     boolean[][] self,  int[][] matrix){
        // if currently work through pacific, then "self" refers to pacific_visited, "other" : atlantic_visited; else also
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()){
            int[] cur = new int[2];
            cur = queue.poll();
            //if cur was visited in "other"，then it belongs to the overlapped nodes，which can be added to res

            for(int[] dir: directions){
                int i = cur[0] + dir[0];
                int j = cur[1] + dir[1];
                if(i >= 0 && i < row && j >= 0 && j < col && !self[i][j] && matrix[i][j] >= matrix[cur[0]][cur[1]]){
                    queue.offer(new int[] {i, j});
                    self[i][j] = true;
                }
            }
            
            
        }
    }
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        // enqueue up & left matrix nodes
        for(int i = 0; i < col; i++){   
            queue.offer(new int[] {0, i});
            pacific[0][i] = true;
        } 
        for(int j = 1; j < row; j++){
            queue.offer(new int[] {j, 0});
            pacific[j][0] = true;
        }
        bfs(res, queue, pacific,  matrix);
        
        // enqueue down & right matrix nodes
        for(int i = 0; i < col; i++){
            queue.offer(new int[] {row - 1, i});
            atlantic[row - 1][i] = true;
        }
        for(int j = 0; j < row - 1; j++){
            queue.offer(new int[] {j, col - 1}); 
            atlantic[j][col - 1] = true;
        }
        bfs(res,queue, atlantic,  matrix);
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    res.add(l);
                }
            }
        }
        
        return res;
    }   
}

//https://leetcode.com/problems/pacific-atlantic-water-flow/discuss/440500/Simple-Java-BFS-low-memory(92.86)
