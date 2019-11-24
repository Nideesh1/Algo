public class Solution {
    int len;
    public boolean circularArrayLoop(int[] nums) {
        // Handle bad input
        if (nums == null || nums.length < 2) return false;
        
        len = nums.length;
        
        /**
         * Check every possible start location.
         * We may start at a short-loop, for instance, but the Array
         * may still contain a valid loop.
         */
        for (int i = 0; i < len; i++) {
            /**
             * We set elements to 0 which are on known non-loop paths.
             * So, if we encounter a 0, we know we're not on a loop path.
             * So, move to the next start location in the list.
             */
            if (nums[i] == 0) continue;
            
            // Stagger our starts, so we don't conclude we've found a loop,
            // as we might otherwise when slow == fast.
            int slow = i, fast = advance(nums, slow);
            
            /** 
             * Whether i is positive or negative defines our direction, so if
             * the directions differ, so too will the signs.
             * If the signs differ, we can't be in a 'forward' or a 'backward'
             * loop, so we exit the traverse.
             */
            while (nums[i] * nums[fast] > 0 &&
                    nums[i] * nums[advance(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow == advance(nums, slow)) break; // 1-element loop
                    return true;
                }
                slow = advance(nums, slow);
                fast = advance(nums, advance(nums, fast));
            }
            
            /**
             * If we're here, we didn't find a loop, so we know this path
             * doesn't have a loop, so we re-traverse it until we reverse
             * direction or encounter a '0' element.
             * During the re-traverse, we set each element we see to 0.
             */
            slow = i;
            int sgn = nums[i];
            while (sgn * nums[slow] > 0) {
                int tmp = advance(nums, slow);
                nums[slow] = 0;
                slow = tmp;
            }
        }
        
        // We've tested the whole array and have not found a loop,
        // therefore there isn't one, so return false.
        return false;
    }
    public int advance(int[] nums, int i) {
        int n = nums.length;
        return i + nums[i] >= 0 ? (i + nums[i]) % n : ((i + nums[i]))%n + n;
        //return i + nums[i] >= 0? (i + nums[i]) % n: n + ((i + nums[i]) % n);
    }

}
//https://leetcode.com/problems/circular-array-loop/discuss/94148/Java-SlowFast-Pointer-Solution
