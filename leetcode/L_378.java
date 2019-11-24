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

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        
        int lo = matrix[0][0]; 
        int hi = matrix[n-1][n-1];
        
        while(lo < hi){
            int mid = lo + (hi - lo)/2;
            
            int count = 0; int j = n-1;
            for(int i = 0; i < n; i++){
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                count += j + 1;
            }
            
            if(count < k)lo = mid + 1;
            else hi = mid;
        }
        
        return lo;
    }
}

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/301357/Java-0ms-(added-Python-and-C%2B%2B)%3A-Easy-to-understand-solutions-using-Heap-and-Binary-Search

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
