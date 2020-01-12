class Solution {
    
    int[][][] dp = new int[27][27][300];
    
    public int minimumDistance(String word) {
        return dfs(word, 0, null, null);
    }
    
    public int dfs(String word, int pos, Character left, Character right){
        if(pos >= word.length()) return 0;
        
        int idx1 = left == null ? 0 : left - 'A' + 1;
        int idx2 = right == null ? 0 : right - 'A' + 1;
        
        if(dp[idx1][idx2][pos] == 0){
            int leftBranch = dist(left, word.charAt(pos));
            leftBranch += dfs(word, pos+1, word.charAt(pos), right);
            
            int rightBranch = dist(right, word.charAt(pos));
            rightBranch += dfs(word, pos + 1, left, word.charAt(pos));
            
            dp[idx1][idx2][pos] = Math.min(leftBranch, rightBranch);
        }
        
        return dp[idx1][idx2][pos];
    }
    
    public int dist(Character from, Character to){
        if(from == null || to == null) return 0;
        int c1 = from - 'A';
        int c2 = to - 'A';
        int x1 = c1 / 6; int y1 = c1 % 6;
        int x2 = c2 / 6; int y2 = c2 % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

//https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/discuss/477659/Top-Down-DP
