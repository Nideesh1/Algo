class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean incom = false;
        while(!q.isEmpty()){
            
            
            int size = q.size();
            for(int i = 0; i < size; i++){
            TreeNode cur = q.poll();
            
            if(cur.left != null){
                if(incom){return false;}
                q.add(cur.left);
            }else{
                incom = true;
            }
            
            if(cur.right != null){
                if(incom){return false;}
                q.add(cur.right);
            }else{
                incom = true;
            }
            }
        }
        return true;
    }
}

class Solution {
    int tot = 0;
    public boolean isCompleteTree(TreeNode root) {
        in(root);
        System.out.println(tot);
        return dfs(root, 0);
    }
    
    public boolean dfs(TreeNode root, int index){
        if(root == null)return true;
        if(index >= tot) return false;
        return dfs(root.left, index*2 + 1) && dfs(root.right, index*2 + 2);
        
    }
    
    
    public void in(TreeNode root){
        if(root == null)return;
        in(root.left);
        tot++;
        in(root.right);
    }
}

//https://www.geeksforgeeks.org/check-whether-binary-tree-complete-not-set-2-recursive-solution/
//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
