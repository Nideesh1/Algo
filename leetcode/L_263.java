class Solution {
    public boolean isUgly(int num) {
        int[] p = {2,3,5};
        int t = num;
        while(num != 1){
            t = num;
            for(int i = 0; i < p.length; i++){
                if(num % p[i] == 0){
                    num /= p[i];
                }
            }
            if(t == num) return false;
        }
        return true;
    }
}

//https://leetcode.com/problems/ugly-number/
