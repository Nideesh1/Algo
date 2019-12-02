class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        dfs(board);
    }
    
    public boolean dfs(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                
                if(board[i][j] == '.'){
                    
                    for(char c = '1'; c <= '9'; c++){
                        
                        if(isValid(board, i, j, c)){
                            
                            
                            board[i][j] = c;
                            
                            if(dfs(board)){
                                return true;
                            }
                            
                            board[i][j] = '.';
                        }
                        
                    }
                    
                    return false;
                    
                }
                
            }
        }
        
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char num) {
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
        for (int i = 0; i < 9; i++)
            if (board[i][col] == num || board[row][i] == num || 
                    board[blkrow + i / 3][blkcol + i % 3] == num)
                return false;
        return true;
    }
}

//https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
