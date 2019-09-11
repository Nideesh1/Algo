class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dict = new HashSet<>();
        for(String w : words) dict.add(w);
        List<String> res = new ArrayList<>();
        if(words.length <= 1) return res;
        for(String w : words){
            if(w.equals("")) continue;
            dict.remove(w);
            if(wordBreak(w, dict, new HashMap<>())){
                res.add(w);
            }
            dict.add(w);
        }
        return res;
        
    }
    public boolean wordBreak(String s, Set<String> set, Map<String,Boolean> map){
        if(s.equals("")) return true;
        if(map.containsKey(s)) return map.get(s);
        for(int i = 1; i <= s.length(); i++){
            if(set.contains(s.substring(0, i)) && wordBreak(s.substring(i, s.length()) , set,map )){
                map.put(s.substring(i,s.length()), true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}

    public boolean wordBreak(String s, Set<String> set){
        int n = s.length();
        //is substring from 0 to n a valid word
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            inner:
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true; break inner;
                }
            }
        }
        return dp[n];
    }
    
    //https://leetcode.com/problems/concatenated-words/
