class Solution {
    public int numRookCaptures(char[][] board) {
        int res = 0;
        int iR = 0; 
        int jR = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'R'){ iR = i; jR = j;}
            }
        }
        System.out.println("iR " + iR);
        System.out.println("jR " + jR);
        int ip = iR; int jp = jR;
        //Going up
        up:
        while(!outOfBounds(board,ip,jp) && !sameTeam(board,ip,jp)){

            System.out.println("ip " + ip);
            System.out.println("jp " + jp);
            if(board[ip][jp] == 'p'){
                res++; break up;
            }
                        ip--;
        }
        ip = iR;
        jp = jR;
        down:
        while(!outOfBounds(board,ip,jp) && !sameTeam(board,ip,jp)){

            if(board[ip][jp] == 'p'){
                res++; break down;
            }
                        ip++;
        } 
        ip = iR;
        jp = jR;        
        left:
        while(!outOfBounds(board,ip,jp) && !sameTeam(board,ip,jp)){

            if(board[ip][jp] == 'p'){
                res++; break left;
            }
                        jp--;
        } 
        ip = iR;
        jp = jR;        
        right:
        while(!outOfBounds(board,ip,jp) && !sameTeam(board,ip,jp)){
           
            if(board[ip][jp] == 'p'){
                res++; break right;
            }
             jp++;
        }        
        return res;
    }
    
    public boolean outOfBounds(char[][] board, int i , int j){
        if( i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return true;
        }
        return false;
    }
    
    public boolean sameTeam(char[][] board, int i, int j){
        if((board[i][j] == 'B')){
            return true;
        }
        return false;
    }
}

//https://leetcode.com/problems/available-captures-for-rook/submissions/
