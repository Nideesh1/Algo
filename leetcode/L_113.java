/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        dfs(root, sum, res, new ArrayList());
        return res;
    }
    private void dfs(TreeNode root, int target, List<List<Integer>> res, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && target == root.val)
            res.add(new ArrayList(list));
        dfs(root.left, target - root.val, res, list);
        dfs(root.right, target - root.val, res, list);
        list.remove(list.size() - 1);
    }
}


class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        recur(root, paths, "");
        System.out.println(paths);
        for(String s : paths){
            if(sum == sumIt(s)){
                res.add(strToInt(s));
            }
        }
        return res;
    }
    
    public List<Integer> strToInt(String s){
        String[] ar = s.split("->");
        List<Integer> res = new ArrayList<>();
        for(String str : ar){
            res.add(Integer.parseInt(str));
        }        
        return res;
    }
    
    public int sumIt(String s){
        String[] ar = s.split("->");
        int res = 0;
        for(String str : ar){
            res += Integer.parseInt(str);
        }
        return res;
    }
    
    public void recur(TreeNode root, List<String> paths, String path){
        if(root == null) return;
        path += Integer.toString(root.val);
        if(root.left == null && root.right == null){
            paths.add(path);
        }
        path += "->";
        recur(root.left, paths, path);
        recur(root.right, paths, path);
    }
}

//https://leetcode.com/problems/path-sum-ii/
