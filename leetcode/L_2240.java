class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0;
        for (int cost = 0; cost <= total; cost += cost1) {
            res += ((total - cost) / cost2) + 1;
        }
        return res;
    }
}

//TLE
class Solution {
    int res = 0;
    Set<String> vis = new HashSet<>();
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        dfs(total, 0, cost1, 0, cost2, 0);
        System.out.println(res);
        return res;
    }
    public void dfs(int total, int cur, int cost1, int cost1Count, int cost2, int cost2Count) {
        if (cur > total) return;
        String key = cost1Count + "," + cost2Count;
        if (vis.contains(key)) return;
        vis.add(key);
        res++;
        //System.out.println("cost1Count " + cost1Count + " cost2Count " + cost2Count + " cur " + cur );
        dfs(total, (cost1 * (cost1Count + 1)) + (cost2 * cost2Count), cost1, cost1Count + 1, cost2, cost2Count);
        dfs(total, (cost1 * cost1Count) + (cost2 * (cost2Count + 1)), cost1, cost1Count, cost2, cost2Count + 1);
        //dfs(total, cost1 * cost1Count + cost2 * cost2Count, cost1, cost1Count + 1, cost2, cost2Count + 1);
    }
}
