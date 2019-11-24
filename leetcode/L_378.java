class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Comparator<Tuple> co = new Comparator<Tuple>(){
            public int compare(Tuple t1, Tuple t2){
                return t1.val - t2.val;
            }
        };
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>(co);
        for(int j = 0; j < n; j++){
            pq.add(new Tuple(0, j, matrix[0][j]));
        }
        
        for(int i = 0; i < k - 1; i++){
            Tuple t = pq.poll();
            if(t.x == n - 1)continue;
            pq.add(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        
        return pq.poll().val;
    }
    
    class Tuple {
        int x; int y; int val;
        public Tuple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
