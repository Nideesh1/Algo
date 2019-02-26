/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Stack
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        
        Stack<TreeNode[]> stk = new Stack<>();
        stk.push(new TreeNode[]{t1,t2});
        while(!stk.isEmpty()){
            TreeNode[] t = stk.pop();
            if(t[0] == null || t[1] == null){
                continue;
            }
            
            t[0].val += t[1].val;

            if(t[0].left == null){
                t[0].left = t[1].left;
            }else{
                stk.push(new TreeNode[]{t[0].left, t[1].left});
                
            }
            if(t[0].right == null){
                t[0].right = t[1].right;
            }else{
                stk.push(new TreeNode[]{t[0].right, t[1].right});
                
            }            
            
        }
        return t1;
        
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
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}


//https://leetcode.com/problems/merge-two-binary-trees/description/
