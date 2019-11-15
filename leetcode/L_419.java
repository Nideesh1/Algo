class Solution {
    public int countBattleships(char[][] board) {
        
        int count = 0;
        
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.') continue;
                //vertical 
                if(i > 0  && board[i-1][j] == 'X') continue;
                
                //horizontal
                if(j > 0 && board[i][j-1] == 'X') continue;
                
                count++;
            }
        }
        
        return count;
    }
}

//https://leetcode.com/problems/battleships-in-a-board/discuss/90902/Simple-Java-Solution
