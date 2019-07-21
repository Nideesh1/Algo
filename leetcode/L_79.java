class Solution {
    int[] x = {0,0,-1,1};
    int[] y = {-1,1,0,0};
    
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;
        if(m*n < word.length()) return false;
        
        boolean res = false;
        
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    
                    if(dfs(word, board, 0, i, j)){
                        return true;
                    }
                }
            }
        }
        return res;
    }
    
    public boolean dfs(String word, char[][] board, int pos, int i, int j){
        if(outside(board, i, j)) return false;
        if(board[i][j] == '-') return false;
        if(board[i][j] != word.charAt(pos)) return false;
        if(word.length() == pos+1) return true;
        
        
        boolean side = false;
            
            char t = board[i][j];
            board[i][j] = '#';
            
            for(int k = 0; k < x.length; k++){
                int ro = i + x[k];
                int co = j + y[k];
                
                if(dfs(word, board, pos+1, ro, co)){
                    return true;
                }
            }
            
            board[i][j] = t;
            
        
        return side;
    }
    
    public boolean outside(char[][] board, int i , int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return true;
        }
        return false;
    }
}

//https://leetcode.com/problems/word-search/
