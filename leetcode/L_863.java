class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map= new HashMap<>();
        Queue<TreeNode> q= new LinkedList<>();
        Set<TreeNode> vis= new HashSet<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur= q.poll();
            if (cur==target) break;
            if (cur.left!=null){
                map.put(cur.left, cur);
                q.add(cur.left);
            }
            if (cur.right!=null){
                map.put(cur.right, cur);
                q.add(cur.right);
            }
        }
        q.clear();
        q.add(target);
        vis.add(target);
        while(K-->0){
            if (q.isEmpty()) return new LinkedList<>();
            for (int sz=q.size(); sz>0; sz--){
                TreeNode cur=q.poll();
                if (cur.left!=null && vis.add(cur.left)) q.add(cur.left);
                if (cur.right!=null && vis.add(cur.right)) q.add(cur.right);
                if (map.get(cur)!=null && vis.add(map.get(cur))) q.add(map.get(cur));
            }
        }
        List<Integer> res= new LinkedList<>();
        while(!q.isEmpty()) res.add(q.poll().val);
        return res;
    }
}

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143752/JAVA-Graph-+-BFS/151219
