class Solution {
    int MAX = 1000000007;
    
    int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    Map<String,Long> map = new HashMap<>();
    public int knightDialer(int n) {
        long res = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                res = (res + dfs(i, j, n)) % MAX;
            }
        }
        return (int) res;
    }
    public long dfs(int i, int j, int n) {
        if (i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)) return 0;
        if (n == 1) return 1;
        String key = i + "," + j + "," + n;
        if (map.containsKey(key)) return map.get(key);
        long res = 0;
        for (int[] dir : dirs) {
            int ro = i + dir[0];
            int co = j + dir[1];
            res += dfs(ro, co, n - 1) % MAX;
        }
        map.put(key, res);
        return res;
    }
}

//https://leetcode.com/problems/knight-dialer/discuss/190787/How-to-solve-this-problem-explained-for-noobs!!!/256076
