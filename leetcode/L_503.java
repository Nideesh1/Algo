class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        //Stack is holding indexes of monotonic stack
        Stack<Integer> stk = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        int n = nums.length;
        for (int i = 0; i < n * 2; i++) {
            while(!stk.isEmpty() && nums[i % n] > nums[stk.peek()]) {
                res[stk.pop()] = nums[i % n];
            }
            stk.push(i % n);
        }
        return res;
    }
}
