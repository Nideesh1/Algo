class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res, num, target, "", 0, 0, 0);
        return res;
    }
    public void dfs(List<String> res, String num, int target, String exp, int pointer, long evald, long prevChange){
        if(pointer == num.length()){
            if(target == evald){
                res.add(exp); return;
            }
        }
        for(int i = pointer; i < num.length(); i++){
            if(i != pointer && num.charAt(pointer) == '0') break;
            long cur = Long.parseLong(num.substring(pointer, i+1));
            if(pointer == 0){
                //choodam
                dfs(res, num, target, exp + cur, i + 1, cur, cur);
            }else{
                dfs(res, num, target, exp + "+" + cur, i + 1, evald + cur, cur); 
                dfs(res, num, target, exp + "-" + cur, i + 1, evald - cur, -cur); 
                dfs(res, num, target, exp + "*" + cur, i + 1, evald - prevChange + (prevChange * cur), (prevChange * cur));                
            }
        }
    }
}
//https://leetcode.com/problems/expression-add-operators/
//https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear
