class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer,Integer> color = new HashMap<>();
        
        for(int n = 1; n <= N; n++){
            color.put(n, -1);
        }
        
        for(int i = 0; i < dislikes.length; i++){
            
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            
            List<Integer> l1 = map.getOrDefault(u, new ArrayList<>());
            l1.add(v); map.put(u, l1);
            
            List<Integer> l2 = map.getOrDefault(v, new ArrayList<>());
            l2.add(u); map.put(v, l2);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int n = 1; n <= N; n++){
            
            
            
            if(color.get(n) == -1){
                q.offer(n); 
                color.put(n, 0);
            }
            
            while(!q.isEmpty()){
                int cur = q.poll();
                int col = color.get(cur);
                for(int nei : map.getOrDefault(cur, new ArrayList<>())){
                    
                    if(color.get(nei) == col) return false;
                    else if(color.get(nei) == -1){
                        color.put(nei, 1 - col);
                        q.add(nei);
                    }
                    
                }
            }
            
        }
        return true;
    }
}

//https://leetcode.com/problems/possible-bipartition/
