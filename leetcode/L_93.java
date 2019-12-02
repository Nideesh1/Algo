class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return ans;
        dfs(s, ans, "", 0);
        return ans;
    }
    
    private void dfs(String s, List<String> ans, String restored, int count) {
        if(count == 4 && s.isEmpty()){
            ans.add(restored);
            return; 
        } 
        
        for(int i = 1; i <= Math.min(3, s.length()); i++){
            String sec = s.substring(0, i);
            
            if(sec.length() > 1 && sec.charAt(0) == '0' )continue;
            if(sec.length() == 3 && Integer.valueOf(sec) > 255) continue;
            dfs(s.substring(i), ans, restored + sec + (count < 3 ? "." : ""), count + 1);
        }
    
    }
}

//https://leetcode.com/problems/restore-ip-addresses/discuss/30944/Very-simple-DFS-solution/137691
