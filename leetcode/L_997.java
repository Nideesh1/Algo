class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length == 0){return 1;}
        
        Set<Integer> outgoing = new HashSet<>();
        Map<Integer,Integer> indegree = new HashMap<>();
        for(int[] t : trust){
            outgoing.add(t[0]);
            indegree.put(t[1], indegree.getOrDefault(t[1], 0) +1);
        }
        for(int in : indegree.keySet()){
            if(indegree.get(in) == N - 1 && !outgoing.contains(in)) return in;
        }
        return -1;
    }
}
