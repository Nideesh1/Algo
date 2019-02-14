class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        //Key is node, value is list  of int[]. The int[] is setup like [dest-node, distance]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] i : times){
            if(!graph.containsKey(i[0])){
                List<int[]> l = new ArrayList<>(); l.add(new int[]{i[1], i[2]}); graph.put(i[0], l);
            }else{
                graph.get(i[0]).add(new int[]{i[1], i[2]});
            }
        }

        //Heap is min-heap of int[]. The int[] is setup like [distance from source node, given node]
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( (info1, info2) -> info1[0] - info2[0]);
        
        //Key is node, value is distance from source node K
        Map<Integer,Integer> dist = new HashMap<>();
        pq.add(new int[]{0, K});
        
        while(!pq.isEmpty()){
            int[] t = pq.poll(); int d = t[0]; int node = t[1];
            if(dist.containsKey(node)){continue;}
            dist.put(node, d);
            if(graph.containsKey(node)){
                for(int[] i : graph.get(node)){
                    int neighbour = i[0]; int d2 = i[1];
                    if(!dist.containsKey(neighbour)){
                        pq.add(new int[]{d+d2, neighbour});
                    }
                }
            }
        }
                System.out.println(dist);
        if(dist.size() != N){return -1;}
        int ans = 0;
        for(int cand : dist.values()){
            ans = Math.max(ans, cand);
        }
        return ans;
    }
}

//https://leetcode.com/problems/network-delay-time/description/
