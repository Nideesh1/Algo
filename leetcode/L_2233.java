class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) pq.add(n);
        for (int i = 0; i < k; i++) {
            pq.add(pq.poll() + 1);
        }
        long res = 1;
        int mod = 1_000_000_007;
        while (!pq.isEmpty()) res = (res * pq.poll()) % (mod);
        return (int) res;
    }
}
