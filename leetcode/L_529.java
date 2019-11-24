class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        int m = board.length; int n = board[0].length;
        
        if(board[row][col] == 'M'){
            board[row][col] = 'X';
        }else{
            int count = 0;
            
            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++){
                    
                    if(i ==0 && j == 0)continue;
                    
                    int ro = row + i;
                    int co = col + j;
                    
                    if(outside(board, ro, co))continue;
                    if(board[ro][co] == 'M' || board[ro][co] == 'X'){
                        count++;
                    }
                }
            }
            //if not a B stop further DFS
            if(count > 0){
                board[row][col] = (char) (count + '0');
            }else{
                board[row][col] = 'B';
                for(int i = -1; i < 2; i++){
                    for(int j = -1; j < 2; j++){

                    if(i ==0 && j == 0)continue;
                        
                    int ro = row + i; int co = col + j;
                        if(outside(board, ro, co)) continue;
                        if(board[ro][co] == 'E'){
                            updateBoard(board, new int[]{ro,co});
                        }
                    }
                }
            }
        }
        return board;
    }
    
    public boolean outside(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length) return true;
        return false;
    }
}

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length; 
        int n = board[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(click);
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int row = cur[0]; int col = cur[1];
            
            if(board[row][col] == 'M'){
                board[row][col] = 'X';
            }else{
                int count = 0;
                
                //count the num of bombs
                for(int i = -1; i < 2; i++){
                    for(int j = -1; j < 2; j++){
                        
                        
                        if(i == 0 && j == 0)continue;
                        
                        int ro = row + i; int co = col + j;
                        if(outside(board, ro, co))continue;
                        if(board[ro][co] == 'M' || board[ro][co] == 'X') count++;
                    }
                }
            
                //if not B then change it
                if(count > 0){
                    board[row][col] = (char) (count + '0');
                }else{
                    
                
                //change to Bs
                board[row][col] = 'B';
                for(int i = -1; i < 2; i++){
                    for(int j = -1; j < 2; j++){
                        
                        
                        if(i == 0 && j == 0)continue;
                        
                        int ro = row + i; int co = col + j;
                        if(outside(board, ro, co))continue;
                        if(board[ro][co] == 'E'){
                            q.add(new int[]{ro,co});
                            board[ro][co]  = 'B';
                        }
                        
                    }
                }                    
                    
                }
            }
            
        }
        return board;
    }
    
    public boolean outside(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return true;
        return false;
    }
}

//https://leetcode.com/problems/minesweeper/discuss/99826/Java-Solution-DFS-%2B-BFS
//https://leetcode.com/problems/minesweeper/
