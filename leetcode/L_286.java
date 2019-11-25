class Solution {
    
    int[] x = {0,0,-1,1};
    int[] y = {1,-1,0,0};
    
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[i].length; j++){
                if(rooms[i][j] == 0){
                    q.add(new int[] {i, j});
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0]; int j = cur[1];
            for(int k = 0; k < x.length; k++){
                int ro = i + x[k];
                int co = j + y[k];
                
                if(outside(rooms, ro, co) || rooms[ro][co] != Integer.MAX_VALUE) continue;
                rooms[ro][co] = rooms[i][j] + 1;
                q.add(new int[]{ro,co});
            }
        }
    }
    
    public boolean outside(int[][] rooms, int i, int j){
        if(i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length)return true;
        return false;
    }
}

//https://leetcode.com/problems/walls-and-gates/solution/
