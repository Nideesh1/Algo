class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length == 0){return 1;}
        Map<Integer,List<Integer>> town = new HashMap<>();
        for(int[] t : trust){
            List<Integer> l = town.getOrDefault(t[0], new ArrayList<>());
            l.add(t[1]);
            town.put(t[0], l);
        }
        Map<Integer, Integer> trustCount = new HashMap<>();
        for(List<Integer> l : town.values()){
            for(Integer i : l){
                int num = trustCount.getOrDefault(i,0) + 1;
                trustCount.put(i,num);
            }
        }
        System.out.println(trustCount);
        for(Map.Entry<Integer,Integer> entry : trustCount.entrySet()){
            if(entry.getValue() == N-1 && !town.containsKey(entry.getKey())){
                return entry.getKey();
            }
        }
        return -1;
    }
}

//https://leetcode.com/problems/find-the-town-judge/description/
