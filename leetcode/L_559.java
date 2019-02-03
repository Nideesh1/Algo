//BFS
class Solution {
  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    } else if (root.children.isEmpty()) {
      return 1;  
    } else {
      //List<Integer> heights = new LinkedList<>();
      int max = 0;
      for (Node item : root.children) {
        //heights.add(maxDepth(item));
          max = Math.max( max, maxDepth(item));
      }
      return max + 1;
    }
  }
}

//DFS
class Solution {
    public int maxDepth(Node root) {
        if(root == null){return 0;}
        if(root.children.isEmpty()){return 1;}
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int layers = 0;
        while(!q.isEmpty()){
            int size = q.size(); layers++;
            for(int i =0; i < size; i++){
                    Node n = q.poll();
                    for(Node p : n.children){
                        q.add(p);
                    }
            }
        }
        return layers;
    }
}

//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
