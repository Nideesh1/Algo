class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for(int row = 0; row < board.length; row ++){
            for(int col = 0; col < board[row].length; col++){
                
                char val = board[row][col];
                
                if(val != '.'){
                    
                    int block = (row / 3 * 3) + (col /3 );
                    
                    if(set.contains("r" + row + val) ||
                      set.contains("c" + col + val) || 
                      set.contains("b" + block + val)){
                        return false;
                    }else{
                        set.add("r" + row + val);
                        set.add("c" + col + val);
                        set.add("b" + block + val);
                    }
                    
                }
                
            }
        }
        
        return true;
    }
}

//https://leetcode.com/problems/valid-sudoku/discuss/15450/Shared-my-concise-Java-code/146624
