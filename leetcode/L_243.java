class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> m= new HashMap<>();
        for(int i = 0; i < words.length; i++){
            List<Integer> l = m.getOrDefault(words[i], new ArrayList<>());
            l.add(i);
            m.put(words[i], l);
        }
        return dist(m.get(word1), m.get(word2));
    }
    
    public int dist(List<Integer> l1, List<Integer> l2){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < l1.size(); i++){
            for(int j = 0; j < l2.size(); j++){
                int dist = Math.abs(l1.get(i) - l2.get(j));
                min = Math.min(min, dist);
            }
        }
        return min;
    }
}

//https://leetcode.com/problems/shortest-word-distance/description/
