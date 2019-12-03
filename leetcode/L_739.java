class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < T.length; i++){
            while(!stk.isEmpty() && T[i] > T[stk.peek()]){
                int idx = stk.pop();
                res[idx] = i - idx;
            }
            stk.push(i);
        }
        
        return res;
    }
}

//https://leetcode.com/problems/daily-temperatures/solution/
