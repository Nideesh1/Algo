class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1) return 0;
        int n = nums.length;
        int level = 0, i = 0, curMax = 0, furthest = 0;
        while(i <= curMax){
            while(i <= curMax){
                furthest = Math.max(furthest, nums[i] + i);
                if(furthest >= n - 1) return level + 1;
                i++;
            }
            curMax = furthest;
            level++;
        }
        return -1;
    }
}

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        vis[0] = true; q.add(0);
        int layer = 0;
        while(!q.isEmpty()){
            int size = q.size();
            layer++;
            for(int s = 0; s < size; s++){
                int cur = q.poll();
                if(cur == n-1) return layer - 1;
                for(int j = 1; j <= nums[cur]; j++){
                    int temp = j + cur;
                    if(temp >= n) break;
                    if(vis[temp]) continue;
                    q.add(temp); vis[temp] = true;
                }
            }
        }
        return -1;
    }
}


class Solution {
    int[] dp;
    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs (nums, 0);
    }
    public int dfs(int[] nums, int p) {
        if (p >= nums.length - 1) return 0;
        if (dp[p] != -1) return dp[p];
        //System.out.println(p);
        int min = Integer.MAX_VALUE;
        for (int i = p; i < nums[p] + p; i++) {
            int res = dfs(nums, 1 + i);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + res);
            }
        }
        dp[p] = min == Integer.MAX_VALUE ? -1 : min;
        return min;
    }
}

//https://leetcode.com/problems/jump-game-ii/discuss/18028/O(n)-BFS-solution
//https://leetcode.com/problems/jump-game-ii/discuss/18028/O(n)-BFS-solution/228614
