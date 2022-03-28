class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        Map<Integer,Map<Integer,Integer>> prices = 
            new HashMap<>();
        
        for(int[] f : flights){
            Map<Integer,Integer> map = prices.getOrDefault(f[0], new HashMap<>());
            map.put(f[1], f[2]);
            prices.put(f[0], map);
        }
        
       Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        //distance from source, city, stops
        pq.add(new int[]{0, src, K+1});
        while(!pq.isEmpty()){
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            
            if(city == dst) return price;
            
            if(stops > 0){
                
                Map<Integer,Integer> adj =  prices.getOrDefault(city, new HashMap<>());
                
                for(int a : adj.keySet()){
                    
                    pq.add(new int[]{price + adj.get(a), a, stops - 1});
                    
                }
                
            }
        }
        
        //System.out.println(prices);
        
        return -1;
    }
}

//https://leetcode.com/problems/cheapest-flights-within-k-stops/discuss/115541/JavaPython-Priority-Queue-Solution


class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        for (int[] f : flights) {
            int u = f[0], v = f[1], w = f[2];
            List<int[]> list = map.getOrDefault(u, new ArrayList<>());
            list.add(new int[]{v, w, 0});
            map.put(u, list);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0, -1});
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], dist = cur[1], stop = cur[2];
            if (stop > k || stop > stops[node]) continue;
            stops[node] = stop;
            if (node == dst) return dist;
               if (map.containsKey(node)) {
                for (int[] nei : map.get(node)) {
                    int neiNode = nei[0];
                    int neiDist = nei[1];
                    int neiStop = nei[2];
                    pq.add(new int[]{neiNode, neiDist + dist, stop + 1});
                }
            }
        }
        return -1;
    }
}
