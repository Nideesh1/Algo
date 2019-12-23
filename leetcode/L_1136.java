class Solution {
    Map<Integer,List<Integer>> adj = new HashMap<>();
    int[] ind;
    int n;
    public int minimumSemesters(int N, int[][] relations) {
        ind = new int[N+1];
        n = N;
        for(int[] rel : relations){
            List<Integer> l  = adj.getOrDefault(rel[0], new ArrayList<>());
            
            l.add(rel[1]);
            adj.put(rel[0], l);
            ind[rel[1]]++;
        }
        if(cyc()){

            
            return -1;
        }
        boolean[] vis = new boolean[n+1];
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i <= n; i++){
            if(!vis[i]){
                dp(dp, vis, i);
            }
        }
        int res = -1;
        for(int d : dp) res = Math.max(res, d);
        return res;
    }
    
    public void dp(int[] dp, boolean[] vis, int u){
        if(vis[u]) return;
        vis[u] = true;
        if(!adj.containsKey(u) || adj.get(u).size() == 0)return;
        for(int nei : adj.get(u)){
            if(!vis[nei]){
                dp(dp, vis, nei);
            }
            dp[u] = Math.max(dp[u], dp[nei] + 1);
        }
    }

    
    public boolean cyc(){
        Queue<Integer> q = new LinkedList<>();
        int size = 0;
        for(int i = 1; i < ind.length; i++){
            if(ind[i] == 0) {q.add(i);}
            
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            //System.out.println(cur);
            if(ind[cur] == 0){size++;}
            if(!adj.containsKey(cur))continue;
            for(int nei : adj.get(cur)){
                ind[nei]--;
                if(ind[nei] == 0){
                    q.add(nei);
                }
            }
        }
        return size != n;
    }
}

//https://leetcode.com/problems/parallel-courses/
