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

//https://leetcode.com/problems/course-schedule/
