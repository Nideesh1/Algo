class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 1, k, n);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> temp, int start, int k, int n){
        if(temp.size() == k && n == 0){
            List<Integer> l = new ArrayList<>(temp);
            res.add(l);
            return;
        }
        for(int i = start; i <= 9; i ++){
            temp.add(i);
            dfs(res, temp, i + 1, k, n - i);
            temp.remove(temp.size() - 1);
        }
    }
}

//https://leetcode.com/problems/combination-sum-iii/discuss/60719/Combination-Sum-I-II-and-III-Java-solution-(see-the-similarities-yourself)
