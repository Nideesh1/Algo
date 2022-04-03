class Leaderboard {
    // playerId to score
    Map<Integer,Integer> map;
    // score and how many times it occurred
    TreeMap<Integer,Integer> scoreCount;
    public Leaderboard() {
        map = new HashMap<>();
        scoreCount = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        if (!map.containsKey(playerId)) {
            map.put(playerId, score);
            scoreCount.put(score, scoreCount.getOrDefault(score, 0) + 1);
        } else {
            int previousScore = map.get(playerId);
            scoreCount.put(previousScore, scoreCount.get(previousScore) - 1);
            if (scoreCount.get(previousScore) == 0) {
                scoreCount.remove(previousScore);
            }
            int newScore = score + previousScore;
            map.put(playerId, newScore);
            scoreCount.put(newScore, scoreCount.getOrDefault(newScore, 0) + 1);
        }
    }
    
    public int top(int K) {
        int count = 0, sum = 0;
        for (int key : scoreCount.keySet()) {
            int times = scoreCount.get(key);
            for (int i = 0; i < times; i++) {
                sum += key;
                count++;
                if (count == K) break;
            }
            if (count == K) break;
        }
        return sum;
    }
    
    public void reset(int playerId) {
        int score = map.get(playerId);
        map.remove(playerId);
        scoreCount.put(score, scoreCount.get(score) - 1);
        if (scoreCount.get(score) == 0) {
            scoreCount.remove(score);
        }
    }
}

//https://leetcode.com/problems/design-a-leaderboard/discuss/418833/Java-TreeMap-%2B-Map-Solution
