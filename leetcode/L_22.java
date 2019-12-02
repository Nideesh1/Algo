class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }
    
    public void dfs(List<String> res, String cur, int start, int end, int max){
        if(cur.length() == max * 2){
            res.add(cur);
            return;
        }
        
        if(start < max){
            dfs(res, cur + "(", start + 1, end, max);
        }
        if(end < start){
            dfs(res, cur + ")", start, end + 1, max);
        }
    }
}

//https://leetcode.com/problems/generate-parentheses/solution/
