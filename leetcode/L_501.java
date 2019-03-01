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
    public int[] findMode(TreeNode root) {
        if(root ==null) return new int[]{};
        Map<Integer,Integer> map = new HashMap<>();
        recur(map, root);
        //System.out.println(map);
        int max = Collections.max(map.values());
        List<Integer> l = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                l.add(entry.getKey());
            }
        }
        int[] res = new int[l.size()];
        for(int i = 0; i < l.size(); i++){
            res[i] = l.get(i);
        }
        
        return res;
    }
    public void recur(Map<Integer,Integer> map, TreeNode root){
        if(root == null)return;
        recur(map, root.left);
        visit(map, root);
        recur(map, root.right);
    }
    public void visit(Map<Integer,Integer> map , TreeNode root){
        int c = map.getOrDefault(root.val, 0) + 1;
        map.put(root.val, c);
    }
}

