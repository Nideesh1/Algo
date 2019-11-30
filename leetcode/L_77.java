class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1, n, k);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> temp, int start, int n, int k){
        if(k == 0){
            res.add(new ArrayList<>(temp));
            return;
        }else{
            for(int i = start; i <= n - k + 1; i++){
                temp.add(i);
                dfs(res, temp, i + 1, n, k - 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

//https://leetcode.com/problems/combinations/discuss/27002/Backtracking-Solution-Java
