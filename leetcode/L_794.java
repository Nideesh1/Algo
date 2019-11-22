class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] row = new int[3];
        int[] col = new int[3];
        boolean xwin = false;
        boolean owin = false;
        int diag = 0;
        int anti = 0;
        int turns = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                
                if(board[i].charAt(j) == 'X'){
                    row[i]++;
                    col[j]++;
                    turns++;
                    if(i == j)diag++;
                    if(i + j == 2) anti++;
                }else if(board[i].charAt(j) == 'O'){
                    row[i]--;
                    col[j]--;
                    turns--;
                    if(i == j)diag--;
                    if(i + j == 2)anti--;
                }
                
            }
        }
        
        
        xwin = row[0] == 3 || row[1] == 3 || row[2] == 3 || col[0] == 3 ||
            col[1] == 3 || col[2] == 3 || diag == 3 || anti == 3;
        owin = row[0] == -3 || row[1] == -3 || row[2] == -3 || col[0] == -3 ||
            col[1] == -3 || col[2] == -3 || diag == -3 || anti == -3;
        
        
        if(xwin && turns == 0 || owin && turns == 1) return false;
        
        return (turns == 0 || turns == 1) && (!xwin || !owin);
        
    }
}

//https://leetcode.com/problems/valid-tic-tac-toe-state/discuss/117580/Straightforward-Java-solution-with-explaination
