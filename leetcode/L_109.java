/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    
    ListNode root;
    
    public TreeNode sortedListToBST(ListNode head) {
        int size = size(head);
        root = head;
        return dfs(0, size - 1);
    }
    
    public TreeNode dfs(int l, int r){
        if(l > r) return null;
        int m = (l + r)/2;
        TreeNode ln = dfs(l, m - 1);
        TreeNode tr = new TreeNode(root.val);
        tr.left = ln;
        
        root = root.next;
        
        TreeNode rn = dfs(m + 1, r);
        tr.right = rn;
        
        return tr;
    }
    
    public int size(ListNode head){
        int res = 0;
        while(head != null){
            res++;
            head = head.next;
        }
        return res;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    List<Integer> list = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        mapList(head);
        return dfs(0, list.size() - 1);
    }
    
    public TreeNode dfs(int l, int r){
        if(l > r) return null;
        int m = (l+r)/2;
        TreeNode node = new TreeNode(list.get(m));
        
        if(l == r) return node;
        
        node.left = dfs(l, m- 1);
        node.right = dfs(m+1, r);
        
        return node;
    }
    
    public void mapList(ListNode head){
        while(head != null){
            list.add(head.val); head = head.next;
        }
    }
}

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/solution/
