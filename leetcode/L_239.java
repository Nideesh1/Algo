class Solution {
    ArrayDeque<Integer> dq = new ArrayDeque<>();
    int[] nums;
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (n == 1) return nums;
        int[] res = new int[n - k + 1];
        int max_idx = 0;
        this.nums = nums;
        for (int i = 0; i < k; i++) {
            clear(i,k);
            dq.addLast(i);
            //check the max indx
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        //System.out.println(dq);
        res[0] = nums[max_idx];
        for (int i = k; i < n; i++) {
            clear(i, k);
            dq.addLast(i);
            // the peekFirst will have the largest, since the largestwas pushed out first
            res[i - k + 1] = nums[dq.peekFirst()];
        }
        return res;
    }
    
    //remove left side if i is out of the window index
    //the biggest one coming in on the right, pushes out everything smaller
    public void clear (int i, int k) {
        while (!dq.isEmpty() && dq.peekFirst() == i - k) {
            dq.pollFirst();
        }
        while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
            dq.pollLast();
        }
    }
}
