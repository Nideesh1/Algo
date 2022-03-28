class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();
        int l = 0, r = 0, ans = 0;
        for (r = 0; r < nums.length; r++) {
            int num = nums[r];
            
            while (!max.isEmpty() && num > max.peekLast()) {
                max.pollLast();
            }
            max.addLast(num);
            
            while (!min.isEmpty() && num < min.peekLast()) {
                min.pollLast();
            }
            min.addLast(num);
            
            while (max.peekFirst() - min.peekFirst() > limit) {
                if (nums[l] == min.peekFirst()) min.pollFirst();
                if (nums[l] == max.peekFirst()) max.pollFirst();
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        
        return ans;
    }
}

