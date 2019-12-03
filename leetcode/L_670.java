class Solution {
    public int maximumSwap(int num) {
        char[] ar = Integer.toString(num).toCharArray();
        
        //last index of each number in the num
        int[] last = new int[10];
        
        for(int i = 0; i < ar.length; i++){
            last[ar[i] - '0'] = i;
        }
        
        for(int i = 0; i < ar.length; i++){
            for(int d = 9; d > ar[i] - '0'; d--){
                
                if(last[d] > i){
                    char t = ar[i];
                    ar[i] = ar[last[d]];
                    ar[last[d]] = t;
                    return Integer.valueOf(new String(ar));
                }
                
            }
        }
        
        return num;
    }
}

//https://leetcode.com/problems/maximum-swap/solution/
