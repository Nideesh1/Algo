class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        Map<String,Boolean> map = new HashMap<>();
        for(String st : wordDict){
            set.add(st);
        }
        return dfs(set, map, s);
    }
    public boolean dfs(Set<String> set, Map<String,Boolean> map, String s){
        if(s.equals("")) return true;
        if(map.containsKey(s)) return map.get(s);
        for(int i = 1; i <= s.length(); i++){
            if(set.contains(s.substring(0, i)) && dfs(set,map, s.substring(i, s.length()))){
                map.put(s.substring(i,s.length()), true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        //is substring from 0 to n a valid word
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            inner:
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true; break inner;
                }
            }
        }
        return dp[n];
    }
}



//https://leetcode.com/problems/word-break/
