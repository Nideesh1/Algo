class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        
        //add new nodes
        while (cur != null) {
            Node add = new Node(cur.val);
            add.next = cur.next;
            cur.next = add;
            cur = add.next;
        }
        
        cur = head;
        
        //put the random pointers, dont let random points to the old list
        while (cur != null) {
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }
        
        //unweaev
        Node old = head, copy = head.next, head_old = head.next;
        while (old != null) {
            old.next = old.next != null ? old.next.next : null;
            copy.next = copy.next != null ? copy.next.next : null;
            
            old = old.next;
            copy = copy.next;
        }
        return head_old;
    }
}

//https://leetcode.com/problems/copy-list-with-random-pointer/solution/
