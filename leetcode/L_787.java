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
