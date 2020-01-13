class Solution {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length; 
        int[] b = new int[n+1];
        
        for(int i = 0; i < n; i++){
            b[i+1] = b[i] + A[i];
        }
        int res = Integer.MAX_VALUE;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n + 1; i++){
            
            while(dq.size() > 0 && b[i] - b[dq.getFirst()] >= K){
                res = Math.min(res, i - dq.pollFirst());
            }
            //keep B[D[i]] increasing in the deque.
            while(dq.size() > 0 && b[i] <= b[dq.getLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C%2B%2BJavaPython-O(N)-Using-Deque
