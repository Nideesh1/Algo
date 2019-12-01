class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++){
            if(ppid.get(i) > 0){
                List<Integer> l = adj.getOrDefault(ppid.get(i), new ArrayList<>());
                l.add(pid.get(i));
                adj.put(ppid.get(i), l);
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(kill);
        while(!q.isEmpty()){
            Integer cur = q.poll();
            res.add(cur);
            if(adj.containsKey(cur)){
                for(int id : adj.get(cur)){
                    q.add(id);
                }
            }
        }
        
        return res;
    }
}


//https://leetcode.com/problems/kill-process/solution/
