class Solution {

    public int rangeSumBST(TreeNode root, int L, int R) {
        int glo = 0;
        if(root == null) return 0;
        if(root.val < L){
            return rangeSumBST(root.right, L, R);
        }
        if(root.val > R){
            return rangeSumBST(root.left, L, R);
        }
        glo += root.val;
        glo += rangeSumBST(root.left, L, R);
        glo += rangeSumBST(root.right, L, R);
        return glo;
    }
}

//https://leetcode.com/problems/range-sum-of-bst/
