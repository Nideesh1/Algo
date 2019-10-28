class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> stk = new Stack<>();
        for(String log : logs){
            String[] ar = log.split(":");
            int pro = Integer.valueOf(ar[0]);
            int end = Integer.valueOf(ar[2]);
            
            if(ar[1].equals("start")){
                stk.push(new int[]{pro, end});
            }
            else if(ar[1].equals("end")){
                
                int timeTaken = end - stk.pop()[1] + 1;
                res[pro] += timeTaken;
                if(!stk.isEmpty()){
                    res[stk.peek()[0]] -= timeTaken;
                }
            }
            
        }
        return res;
    }
}

//https://leetcode.com/problems/exclusive-time-of-functions/
//https://leetcode.com/problems/exclusive-time-of-functions/solution/
//https://leetcode.com/kylewzk
