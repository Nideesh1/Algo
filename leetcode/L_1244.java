class Leaderboard {
    //key is playerId, val is current score
    Map<Integer,Integer> pMap;
    
    //key is score, val is frequency
    TreeMap<Integer,Integer> sMap;
    public Leaderboard() {
        pMap = new HashMap<>();
        sMap = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        if (!pMap.containsKey(playerId)) {
            pMap.put(playerId, score);
            sMap.put(score, sMap.getOrDefault(score, 0 ) + 1);
            return;
        }
        
        int prevScore = pMap.get(playerId);
        sMap.put(prevScore, sMap.get(prevScore) - 1);
        
        int nextScore = prevScore + score;
        pMap.put(playerId, nextScore);
        sMap.put(nextScore, sMap.getOrDefault(nextScore, 0) + 1);
    }
    
    public int top(int K) {
        int res = 0;
        for (int key : sMap.keySet()) {
            int count = sMap.get(key);
            while (K != 0 && count != 0) {
                res += key;
                K--; count--;
            }
        }
        return res;
    }
    
    public void reset(int playerId) {
        int prevScore = pMap.get(playerId);
        sMap.put(prevScore, sMap.get(prevScore) - 1);
        pMap.remove(playerId);
    }
}
