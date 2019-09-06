class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        stk.add(Integer.MAX_VALUE);
        int res = 0;
        for(int i : arr){

            if(stk.peek() >= i){
                stk.push(i);
            }else{
                while(stk.peek() < i){
                    int t = stk.pop();
                    res += t * Math.min(stk.peek(), i);
                }
                stk.push(i);
            }
        }
        //System.out.println(res);
        while (stk.size() > 2) {
            res += stk.pop() * stk.peek();
        }
        return res;
    }
}

//https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
