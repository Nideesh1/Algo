class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String,List<String>> adj = new HashMap<>();
        Set<String> every = new HashSet<>();
        for(List<String> path : paths){
            List<String> edg = adj.getOrDefault(path.get(0), new ArrayList<>());
            edg.add(path.get(1));
            adj.put(path.get(0), edg);
            every.add(path.get(0)); every.add(path.get(1));
        }
        for(String s : every){
            if(!adj.containsKey(s)) return s;
        }
        return "";
    }
}