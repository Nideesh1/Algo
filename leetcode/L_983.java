class Solution {
    int[] costs;
    int[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new int[days[days.length -1]];
        dayset = new HashSet<>();
        for (int d: days) dayset.add(d);

        return dp(days[days.length - 1]);
    }

    public int dp(int i) {
        if (i <= 0)
            return 0;
        if (memo[i-1] != 0)
            return memo[i-1];

        int ans;
        if (dayset.contains(i)) {
            int one = dp(i-1) + costs[0];
            int two = dp(i-7) + costs[1];
            int thr = dp(i-30) + costs[2];
            ans = Math.min(one, Math.min(two, thr));
        } else {
            ans = dp(i-1);
        }

        memo[i-1] = ans;
        return ans;
    }
}

//https://leetcode.com/problems/minimum-cost-for-tickets/solution/
