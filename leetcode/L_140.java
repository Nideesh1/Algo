class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word : wordDict) set.add(word);
        return dfs(s, set, 0);
    }
    
    Map<Integer,List<String>> mem = new HashMap<>();
    
    List<String> dfs(String s, Set<String> set, int point){
        if(mem.containsKey(point)) return mem.get(point);
        List<String> res = new ArrayList<>();
        if(s.equals("") || s.length() == point) {res.add(""); return res;}
    
        for(int i = point + 1; i <= s.length(); i++){
            if(set.contains(s.substring(point, i))){
                
                List<String> temp = dfs(s, set, i);
                mem.put(i, temp);
                for(String t : temp){
                    res.add(s.substring(point, i) + (t.equals("") ? "" : " ") + t);
                }
            }
        }
        mem.put(point, res);
        return res;            
    }

}


//https://leetcode.com/problems/word-break-ii/
