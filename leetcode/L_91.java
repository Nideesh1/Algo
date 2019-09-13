class Solution {
    int count = 0;
    public int numDecodings(String s) {


        Set<String> set = new HashSet<>();
        for(int i = 1; i <= 26; i++){

            set.add(Integer.toString(i));
        }
        return wb2(s, set);
    }
   
    public int wb2(String s, Set<String> set){
        int res = 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if(set.contains(s.substring(0,1))){
            dp[1] = 1;
        }
        for(int i = 2; i <= s.length(); i++){
             for(int j = 1; j <= 2; j++){
                 if(set.contains(s.substring(i-j, i)) && dp[i-j] > 0 ) {
                     dp[i] += dp[i-j];
                 }
             }
        }
        return dp[s.length()];

    }
}
