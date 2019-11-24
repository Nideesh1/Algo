class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            while(stk.peek() != -1 && heights[stk.peek()] >= heights[i]){
                max = Math.max(max, heights[stk.pop()] * (i - stk.peek() - 1));
            }
            stk.push(i);
        }
        int n = heights.length;
        
        while(stk.peek() != -1){
            max = Math.max(max, heights[stk.pop()] * (n - stk.peek() - 1));
        }
        
        return max;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        return dfs(heights, 0, heights.length - 1);
    }
    
    public int dfs(int[] heights, int s, int e){
        if(s > e) return 0;
        
        int minInd = s;
        for(int i = s; i <= e; i++){
            if(heights[i] < heights[minInd]){
                minInd = i;
            }
        }
        int left = dfs(heights, s, minInd - 1);
        int right = dfs(heights, minInd + 1, e);
        return Math.max( heights[minInd] * (e - s + 1) , Math.max(left, right) );
    }
}

//https://leetcode.com/problems/largest-rectangle-in-histogram/solution/
