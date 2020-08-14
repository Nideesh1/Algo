/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        List<String> paths = new ArrayList<>();
        recur(root, paths, "");
        for(String s : paths){
            if(equals(s, sum))return true;
        }
        return false;
    }
    
    public boolean equals(String path, int sum){
        String[] nums = path.split("->");
        int[] ar = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ar[i] = Integer.parseInt(nums[i]);
        }
        for(Integer i : ar){ sum -= i;}
        return sum == 0;
    }
    
    public void recur(TreeNode root, List<String> paths, String path){
        if(root == null) {
            return;
        }
        path += Integer.toString(root.val);
        if(root.left == null && root.right == null){
            paths.add(path);
        }else{
            path += "->";
            recur(root.left, paths, path);
            recur(root.right, paths, path);
        }
        
        
        
    }
}

//Recur
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if(root.left == null && root.right == null){
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}


class Solution {
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }
    public void dfs(TreeNode root, int sum){
        if(root == null) return;
        
        if(root.left == null && root.right == null && sum - root.val == 0) res = true;
        
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }
}
