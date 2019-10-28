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
    TNComp co = new TNComp();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,List<TN>> map = new TreeMap<>();
        dfs(map, root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for(int i : map.keySet()){
            List<TN> l = map.get(i);
            List<Integer> r = new ArrayList<>();
            for(TN tn : l){
                r.add(tn.val);
            }
            res.add(r);
        }
        return res;
    }
    public void dfs(Map<Integer,List<TN>> map, TreeNode root, int col, int dep){
        if(root == null){return;}
        List<TN> l = map.getOrDefault(col, new ArrayList<>());
        l.add(new TN(root.val, dep, col));
        Collections.sort(l, co);
        map.put(col, l);
        dfs(map, root.right, col + 1, dep + 1);
        dfs(map, root.left, col - 1, dep + 1);

    }
    
    class TN{
        int val; int dep; int col;
        TN(int val, int dep, int col){
            this.col = col;
            this.val = val;
            this.dep = dep;
        }
    }
    
    class TNComp implements Comparator<TN>{
        public int compare(TN one, TN two){
            if(one.col != two.col){
                return Integer.compare(one.col , two.col);
            } 
            else if (one.dep != two.dep){
                return Integer.compare(one.dep, two.dep);
            }
            else
                return Integer.compare(one.val, two.val);
        }        
    }
}

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/solution/
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
