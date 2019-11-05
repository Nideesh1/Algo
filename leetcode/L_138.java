class Solution {
    Map<Node,Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        if(map.containsKey(head)){
            return map.get(head);
        }
        
        Node n = new Node(head.val, null, null);
        
        map.put(head, n);
        n.next = copyRandomList(head.next);
        n.random = copyRandomList(head.random);
        
        return n;
    }
}

//https://leetcode.com/problems/copy-list-with-random-pointer/solution/
