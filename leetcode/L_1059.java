class Solution {
    
    enum State {
        PROCESSED, PROCESSING
    }
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new List[n];
        buildGraph(n, edges, graph);
        return dfs(n, graph, source, destination, new State[n]);
    }
    
    public boolean dfs(int n, List<Integer>[] graph, int cur, int destination, State[] states){
        if (states[cur] != null) return states[cur] == State.PROCESSED;
        if (graph[cur].isEmpty()) return cur == destination;
        states[cur] = State.PROCESSING;
        for (int nei : graph[cur]) {
            if (!dfs(n, graph, nei, destination, states)) return false;
        }
        states[cur] = State.PROCESSED;
        return true;
    }
    
    public void buildGraph(int n , int[][] edges, List<Integer>[] graph) {
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] ed : edges) {
            int u = ed[0], v = ed[1];
            graph[u].add(v);
        }
    }
    
}

//https://leetcode.com/problems/all-paths-from-source-lead-to-destination/discuss/303566/Java-DFS-with-cycle-detection-(5ms)
