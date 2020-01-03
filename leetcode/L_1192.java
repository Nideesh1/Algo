class Solution {
public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
	int[] disc = new int[n], low = new int[n];
	// use adjacency list instead of matrix will save some memory, adjmatrix will cause MLE
	List<Integer>[] graph = new ArrayList[n];
	List<List<Integer>> res = new ArrayList<>();
	Arrays.fill(disc, -1); // use disc to track if visited (disc[i] == -1)
	for (int i = 0; i < n; i++) {
		graph[i] = new ArrayList<>();
	}
	// build graph
	for (int i = 0; i < connections.size(); i++) {
		int from = connections.get(i).get(0), to = connections.get(i).get(1);
		graph[from].add(to);
		graph[to].add(from);
	}

	for (int i = 0; i < n; i++) {
		if (disc[i] == -1) {
			dfs(i, low, disc, graph, res, i);
		}
	}
	return res;
}

int time = 0; // time when discover each vertex


    public void dfs(int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int par){
        
        disc[u] = low[u] = ++time;
        
        for(int j = 0; j < graph[u].size(); j++){
            
            
            int v = graph[u].get(j);
            if(v == par)continue;
            
            if(disc[v] == -1){
                dfs(v, low, disc, graph, res, u);
                low[u] = Math.min(low[u], low[v]);
                
                if(low[v] > disc[u]){
                    res.add(Arrays.asList(u,v));
                }
            }else{
                low[u] = Math.min(low[u], disc[v]);
            }
            
        }
        
    }
    
    
}

//https://leetcode.com/problems/critical-connections-in-a-network/discuss/382632/Java-implementation-of-Tarjan-Algorithm-with-explanation
