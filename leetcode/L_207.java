class Solution {
    Map<Integer,List<Integer>> graph = new HashMap<>();
    int[][] p;
    int n;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        p = prerequisites;
        for(int i = 0; i < p.length; i++){
            List<Integer> l = graph.getOrDefault(p[i][1], new ArrayList<>());
            l.add(p[i][0]);
            graph.put(p[i][1], l);
        }
        for(int i = 0; i < numCourses; i++){
            if(!vis.contains(i)){
                if(cycleExist(i)) return false;
            }
        }

        return true;
    }
    
    Set<Integer> vis = new HashSet<>();
    Set<Integer> recur = new HashSet<>();
    
    public boolean cycleExist(int u){
        if(!graph.containsKey(u)) return false;
        if(recur.contains(u)) return true;
        if(vis.contains(u)) return false;
        recur.add(u);
        for(int i : graph.get(u)){
            if(!vis.contains(i)){
                if(cycleExist(i)) return true;
            }
        }
        recur.remove(u);
        vis.add(u);
        return false;
    }
}

class Solution {
    int n;
    int[] indegree;
    Map<Integer,List<Integer>> adj = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n = numCourses;
        indegree = new int[n];
        for(int[] pr : prerequisites){
            List<Integer> l =  adj.getOrDefault(pr[1], new ArrayList<>());
            l.add(pr[0]); indegree[pr[0]]++;
            adj.put(pr[1], l);
        }
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) q.add(i); 
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            if(indegree[cur] == 0)count++;
            if(!adj.containsKey(cur)) continue;
            for(int nei : adj.get(cur)){
                indegree[nei]--;
                if(indegree[nei]== 0) q.add(nei);
            }

        }

        return count == n;
    }
}

//https://leetcode.com/problems/course-schedule/
