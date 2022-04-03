class Solution {
    public int snakesAndLadders(int[][] board) {
        int level = 0;
        int n = board.length;
        boolean[][] vis = new boolean[n][n];
        int start = 1, end = n * n;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[n-1][0] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == end) return level - 1;
            
                for (int dice = 1; dice <= 6; dice++) {
                    int next = cur + dice;
                    if (next > end) break;
                    int[] nextPos = next(next, n);
                    int nextRow = nextPos[0]; int nextCol = nextPos[1];
                    if (!vis[nextRow][nextCol]) {
                        vis[nextRow][nextCol] = true;
                        if (board[nextRow][nextCol] != -1) {
                          q.add(board[nextRow][nextCol]);  
                        } else {
                          q.add(next);                            
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    public int[] next (int next, int n) {
        // r will always be less than n. and we do currentPosition - 1 because our
        // arrays are zero indexed
        // r will be divided by n because we are starting at the bottom
        // c will be % by n, because columns are across a horizontal array
        int r = (n - 1) - (next - 1) / n;
        int c = (next - 1) % n;
        // this is because we are flipping directions on alternating rows 
        if (r % 2 == n % 2 ) return new int[]{r , n - 1 - c};
        return new int[]{r, c};
    }
}

//https://leetcode.com/problems/snakes-and-ladders/discuss/1835869/JAVA-oror-BFS-oror-CLEAND-CONCISE-READABLE-oror
