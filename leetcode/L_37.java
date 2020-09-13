class Solution {
    Set<String> set = new HashSet<>();
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    addToSet(board[i][j], i, j);
                }
            }
        }
        dfs(board);
    }
    public boolean dfs(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    
                    for(char k = '1'; k <= '9'; k++){
                        
                        if(!isValid(k, i, j)) continue;
                        addToSet(k, i, j);
                        board[i][j] = k;
                        if(dfs(board)) return true;
                        removeFromSet(k, i, j);
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char k, int i, int j){
        if(set.contains(k + "row is " + i)) return false;
        if(set.contains(k + "col is " + j)) return false;
        if(set.contains(k + "block is " + i/3 + " " + j/3)) return false;
        return true;
    }
    
    public void addToSet(char k, int i, int j){
        set.add(k + "row is " + i);
        set.add(k + "col is " + j);
        set.add(k + "block is " + i/3 + " " + j/3);
    }
    public void removeFromSet(char k, int i, int j){
        set.remove(k + "row is " + i);
        set.remove(k + "col is " + j);
        set.remove(k + "block is " + i/3 + " " + j/3);
    }    
    
}

//https://leetcode.com/problems/sudoku-solver/discuss/693002/Java-Easy-to-understandread-code
