class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer,Integer> map = map(pairs);
        int res = 0;    
        for (int[] pair : pairs) {
            res += unhappy(pair[0], pair[1], preferences, map);
            res += unhappy(pair[1], pair[0], preferences, map);
        } 
        return res;
    }
    
    public int unhappy (int x, int y, int[][] preferences, Map<Integer,Integer> map) {
        for (int u : preferences[x]) {
            if (u == y) return 0;
            int v = map.get(u);
            for (int uPrefer : preferences[u]) {
                if (uPrefer == x) return 1;
                else if (uPrefer == v) break;
            }
        }
        return 0;
    }
    
    public Map<Integer,Integer> map (int[][] pairs) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int[] p : pairs) {
            map.put(p[0], p[1]);
            map.put(p[1], p[0]);
        }
        return map;
    }
}
