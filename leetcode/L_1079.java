class Solution {
    int count = 0;
    public int numTilePossibilities(String tiles) {
        char[] ar = tiles.toCharArray();
        Arrays.sort(ar);
        boolean[] vis = new boolean[ar.length];
        dfs(ar, 0, vis);
        return count;
    }
    public void dfs(char[] ar, int len, boolean[] vis) {
        if (len == ar.length) {
            return;
        }
        for (int i = 0; i < ar.length; i++) {
            if(vis[i]) continue;
            if (i > 0 && ar[i] == ar[i-1] && !vis[i-1]) continue;
            count++;
            vis[i] = true;
            dfs(ar, len + 1, vis);
            vis[i] = false;
        }
    }
}

//https://leetcode.com/problems/letter-tile-possibilities/discuss/308333/Simple-Java-solution-of-backtracking-no-need-for-extra-space
