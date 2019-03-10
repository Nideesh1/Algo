//Fastest
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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer,Integer> map = new HashMap<>();
        //key is a sum, value is the number of paths that equal that sum
        // node, target sum, map, starting current sum
        //if the difference between current sum and target is zero, we increment res by one;
        map.put(0,1);
        return recur(root, sum, map, 0);
    }
    
    public int recur(TreeNode root, int sum, Map<Integer,Integer> map, int currSum){
        if(root == null) return 0;
        currSum += root.val;
        
        //The number of paths that equal currSum - target
        int res = map.getOrDefault(currSum - sum, 0);
        //Pretty much increment the count of paths that equal currSum
        map.put(currSum, map.getOrDefault(currSum, 0) +1);
        res += recur(root.left, sum, map, currSum);
        res += recur(root.right, sum, map, currSum);
        map.put(currSum, map.get(currSum) - 1);
        return res;
    }
}


//Easiest
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) 
            + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}


//Confusing
public class Solution {
    int target;
    Set<TreeNode> visited;
    public int pathSum(TreeNode root, int sum) {
        target = sum;
        visited = new HashSet<TreeNode>();  // to store the nodes that have already tried to start path by themselves.
        return pathSumHelper(root, sum, false);
    }
    
    public int pathSumHelper(TreeNode root, int sum, boolean hasParent) {
        if(root == null) return 0;
        //the hasParent flag is used to handle the case when parent path sum is 0.
        //in this case we still want to explore the current node.
        if(sum == target && visited.contains(root) && !hasParent) return 0;
        if(sum == target && !hasParent) visited.add(root);
        int count = (root.val == sum)?1:0;
        count += pathSumHelper(root.left, sum - root.val, true);
        count += pathSumHelper(root.right, sum - root.val, true);
        count += pathSumHelper(root.left, target , false);
        count += pathSumHelper(root.right, target, false);
        return count;
    }
}

//https://leetcode.com/problems/path-sum-iii/
