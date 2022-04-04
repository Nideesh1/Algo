//costs[i][j] is the total travel distance from houses[i..j] when putting mailbox in median of houses[i..j]

//costs[i][j] is the total travel distance from houses[i..j] when putting mailbox in median of houses[i..j]

class Solution {
    int MAX = 100, INF = 100 * 10000;
    int[][] costs = new int[MAX][MAX];
    Integer[][] memo = new Integer[MAX][MAX];
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int mid = houses[(i + j) / 2];
                for (int m = i; m <= j; m++) {
                    costs[i][j] += Math.abs(mid - houses[m]);
                }
            }
        }
        return dfs(houses, n, k, 0);
    }
    public int dfs(int[] houses, int n, int k, int i) {
        if (k == 0 && i == n) return 0;
        if (k == 0 || i == n) return INF;
        if (memo[k][i] != null) return memo[k][i];
        int ans = INF;
        for (int j = i; j < n; j++) {
            ans = Math.min(ans, costs[i][j] + dfs(houses, n, k - 1, j + 1));
        }
        return memo[k][i] = ans;
    }
}

//https://leetcode.com/problems/allocate-mailboxes/discuss/685620/JavaC%2B%2BPython-Top-down-DP-Prove-median-mailbox-O(n3)
