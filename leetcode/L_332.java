class Solution {
        List<String> route = new ArrayList<>();
        Map<String,PriorityQueue<String>> targets = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {

        for(List<String> tik : tickets){
            targets.computeIfAbsent(tik.get(0), k -> new PriorityQueue()).add(tik.get(1));
        }
        
        System.out.println(targets);
        
        dfs("JFK");
        return route;
    }
    
    public void dfs(String air){
        while(targets.containsKey(air) && !targets.get(air).isEmpty()){
            dfs(targets.get(air).poll());
        }
        route.add(0, air);
    }
}

//https://leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C%2B%2B
