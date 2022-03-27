class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stk.size() == 0 || nums[i] < nums[stk.peek()]) {
                stk.push(i);
            }
        }
        //System.out.println(stk);
        
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[i] >= nums[stk.peek()]) {
                res = Math.max(res, i - stk.pop());
            }
        }
        return res;
    }
}

