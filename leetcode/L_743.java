class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer,List<int[]>> weightAdj = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
            (int[] a, int[] b) -> a[1] - b[1]
        );
        
        for(int[] edge : times){
            List<int[]> nei = weightAdj.getOrDefault(edge[0], new ArrayList<>());
            nei.add(new int[]{edge[1], edge[2]});
            weightAdj.put(edge[0], nei);
        }        
        
         int res = Integer.MIN_VALUE;
        //map for our question's usecase. Key is node, value is distance 
        //from origin node K. It also acts as a visited set
        Map<Integer,Integer> dist = new HashMap<>();
        pq.add(new int[]{K, 0});
        
        while(!pq.isEmpty()){
            
            int[] cur = pq.poll();
            int node = cur[0];
            int dis = cur[1];
            
            if(dist.containsKey(node)) continue;
            dist.put(node, dis);
            res = Math.max(res, dis);
            if(weightAdj.containsKey(node))
            for(int[] nei : weightAdj.get(node)){
                
                int neiNode = nei[0]; int neiDist = nei[1];
                
                if(!dist.containsKey(neiNode)){
                    pq.add(new int[]{neiNode, neiDist + dis});
                }
            }
        }
   
        

        return dist.size() == N ? res : -1;
    }
}

//https://leetcode.com/problems/network-delay-time/description/
//https://leetcode.com/problems/network-delay-time/solution/
