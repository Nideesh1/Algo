class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        return dfs(0, s);
    }
    public int dfs(int i, String s){
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(map.containsKey(i)) return map.get(i);
        int one = dfs(i+1, s);
        int two = 0;
        if(i + 1 < s.length()){
            int val = Integer.parseInt(s.substring(i, i + 2));
            if(10 <= val && val <= 26){
                two = dfs(i + 2, s);
            }
        }
        map.put(i, one + two);
        return one + two;
    }
}

class Solution {
    public int numDecodings(String s) {
        if(s.isEmpty() || s.length() == 0) return 0;
        int n = s.length();
        
        int[] dp = new int[n+1];
        dp[0]  = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i < dp.length; i++){
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            
            int two = Integer.parseInt(s.substring(i-2, i));
            if(two >= 10 && two <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
