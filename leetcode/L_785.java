class Solution {

        Map<Integer,List<Integer>> g = new HashMap<>();
        Map<Integer,Integer> color = new HashMap<>();
    
    public boolean isBipartite(int[][] graph) {

        for(int i = 0; i < graph.length; i++){
            List<Integer> l = g.getOrDefault(i, new ArrayList<>());
            for(int j : graph[i]){
                l.add(j);
            }
            g.put(i, l);
            color.put(i, -1);
        }
        
        for(int i : g.keySet()){
            if(color.get(i) == -1){
                color.put(i, 0);
                if(dfs(i) == false){
                    return false;
                }
            }
        }
        System.out.println(g);
        System.out.println(color);
        return true;
    }
    
    public boolean bfs(int u){
        Queue<Integer> q = new LinkedList<>();
        q.add(u); color.put(u, 1);
        while(!q.isEmpty()){
            int cur = q.poll();
            int c = color.get(cur);
            
            for(int i : g.get(cur)){
                
                if(color.get(i) == -1 && color.get(i) != c ){
                    color.put(i, 1-c);
                    q.add(i);
                }else if( color.get(i) == c ){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean dfs(int u){
        for(int j : g.get(u)){
            if(color.get(j) == -1){   
                color.put(j, 1 - color.get(u)); 
                if(!dfs(j)) return false;
            }
            if(color.get(j) == color.get(u)) return false;
        }
        
        return true;
    }
}

class Solution {

public boolean isBipartite(int[][] graph) {
	int[] color = new int[graph.length];
	Arrays.fill(color, -1);
	for (int i = 0; i < graph.length; i++)
		if ((color[i] == -1) && !bfs(i, graph, color))
			return false;
	return true;
}

private boolean bfs(int node, int[][] graph, int[] color) {
	Queue<Integer> q = new LinkedList<>();
	q.add(node);
	color[node] = 0;
	while (!q.isEmpty()) {
		int curr = q.poll();
		for (int nei : graph[curr]) {
			if (color[nei] == color[curr])
				return false;
			if (color[nei] == -1) {
				color[nei] = 1 - color[curr];
				q.add(nei);
			}
		}
	}
	return true;
}
}

//https://leetcode.com/problems/is-graph-bipartite/
