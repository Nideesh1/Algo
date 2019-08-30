class Solution {
    Map<Integer,List<Integer>> adj = new HashMap<>();
    public int minimumSemesters(int N, int[][] relations) {
        Map<Integer,Integer> color = new HashMap<>();
        for(int[] rel : relations){
            List<Integer> l = adj.getOrDefault(rel[0], new ArrayList<>());
            l.add(rel[1]);
            adj.put(rel[0], l);
            color.put(rel[0], 0);
        }

        for(int i = 1; i <= N; i++){
            if(color.getOrDefault(i, 4) == 0){
                if(cyc(i, color)) return -1;
            }
        }
        System.out.println("hi");
        
        int[] dp = new int[N+1];Arrays.fill(dp, 1);
        boolean[] vis = new boolean[N+1];
        
        for(int i = 1; i <= N; i++){
            if(!vis[i]){
                dp(i, dp, vis);
            }
        }
        int res = -1;
        for(int d : dp) res = Math.max(res, d);
        return res;
    }
    public void dp(int u, int[] dp, boolean[] vis){
        if(vis[u]) return;
        vis[u] = true;
        if(!adj.containsKey(u) ||  adj.get(u).size() == 0) return;
        for(int nei : adj.get(u)){
            if(!vis[nei]){
                dp(nei, dp, vis);
            }
            dp[u] = Math.max(dp[u], dp[nei] + 1);
        }
    }
    
    public boolean cyc(int i, Map<Integer,Integer> color){
        if(color.get(i) == 2 || !color.containsKey(i)) return false;
        if(color.get(i) == 1) return true;
        
        color.put(i, 1);
        for(int nei : adj.get(i)){
            if(!color.containsKey(nei)) continue;
            if(color.getOrDefault(nei, 4) == 1) return true;
            
            if(color.get(nei) == 0){
                 if(cyc(nei, color)) return true;
            }
        }
        color.put(i, 2);
        return false;
    }
}

//https://leetcode.com/problems/parallel-courses/
