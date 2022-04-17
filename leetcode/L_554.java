class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        //prefix sum means it's at the edge of brick
        Map<Integer,Integer> freq = new HashMap<>();
        int pre = 0;
        for (List<Integer> row : wall) {
            pre = 0;
            for (Integer brick : row) {
                pre += brick;
                freq.put(pre, freq.getOrDefault(pre, 0) + 1);
            }
        }
        int maxEdges = 0;
        for (int k : freq.keySet()) {
            if (k == pre) continue;
            maxEdges = Math.max(maxEdges, freq.get(k));
        }
        return wall.size() - maxEdges;
    }
}

//https://leetcode.com/problems/brick-wall/discuss/133819/My-Java-Solution-With-Explanation
