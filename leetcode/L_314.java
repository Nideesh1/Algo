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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> weight = new HashMap<>();
        
        q.add(root);
        weight.put(root, 0);
        int min = 0;
        
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            int wei = weight.get(cur);

            List<Integer> l = map.getOrDefault(wei, new ArrayList<>());
            l.add(cur.val);
            map.put(wei, l);
            
            if(cur.left != null){
                q.add(cur.left);
                weight.put(cur.left, wei - 1);
            }
            if(cur.right != null){
                q.add(cur.right);
                weight.put(cur.right, wei + 1);
            }
            
            min = Math.min(min, wei);
        }
        while(map.containsKey(min)){
            res.add(map.get(min++));
        }
        
        return res;
    }
}

//https://leetcode.com/problems/binary-tree-vertical-order-traversal/discuss/76463/Using-HashMapBFS-Java-Solution
