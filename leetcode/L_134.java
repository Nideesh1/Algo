class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int temp = 0;
        for(int i = 0; i < gas.length; i++){
            temp += gas[i] - cost[i];
        }
        if(temp < 0){
            return -1;
        }
        
        
        int start = 0;
        int acum = 0;
        for(int i = 0; i < gas.length; i++){
            int cur = gas[i] - cost[i];
            if(acum + cur < 0){
                start = i + 1;
                acum = 0;
            }else{
                acum += cur;
            }
        }
        return start;
    }
}

//https://leetcode.com/problems/gas-station/
//https://leetcode.com/problems/gas-station/solution/
