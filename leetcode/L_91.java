class Solution {
    int count = 0;
    public int numDecodings(String s) {

        Map<String,Character> map = new HashMap<>();
        char c = 'A';
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= 26; i++){
            map.put(Integer.toString(i), c++);
            set.add(Integer.toString(i));
        }
        return wb2(s, set);
    }
   
    public int wb2(String s, Set<String> set){
        int res = 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] > 0 && set.contains(s.substring(j,i))){
                    dp[i] += dp[j]; 
                }
            }
        }
        return dp[s.length()];

    }
}

//https://leetcode.com/problems/decode-ways/
