class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                
                int l = lives(board, i, j);
                
                if(board[i][j] == 1 && l >= 2 && l <= 3){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && l == 3 ){
                    board[i][j] = 2;
                }
                
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = board[i][j] >> 1;
            }
        }
        
        
    }
    
    public int lives(int[][] board, int i, int j){
        int res = 0;
        int m = board.length;
        int n = board[0].length;
        
        for(int x = Math.max(0, i -1); x <= Math.min(i+1, m - 1); x++){
            for(int y = Math.max(0, j - 1); y <= Math.min(j+1, n - 1); y++){
                res += board[x][y] & 1;
            }
        }
        
        res -= board[i][j] & 1;
        return res;
    }
}

//https://leetcode.com/problems/game-of-life/discuss/73223/Easiest-JAVA-solution-with-explanation
