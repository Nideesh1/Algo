//DP
class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        int i = 0; int b = 1; // 2 ^ 0
        
        while(b <= num){
            
            while(i < b && i+b <= num){
                dp[i+b] = dp[i] + 1;
                i++;
            }
            i= 0; // i is the pointer
            b = b << 1; // b is doubled
        }
        return dp;
    }
}

//Mask
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int[] countBits(int num) {
        for(int i = 0; i <= 256; i++){
            map.put(i, mask(i));
        }
        int[] ar = new int[num+1];
        for(int i = 0; i < ar.length; i++){
            ar[i] = count(i);
        }
        return ar;
    }
    
    public int count (int n){
        int one = (int) n & 255; n = n >> 8;
        int two = (int) n & 255; n = n >> 8; 
        int three = (int) n & 255; n = n >> 8;        
        int four = (int) n & 255; n = n >> 8;        
        
        return map.get(one) + map.get(two) + map.get(three) + map.get(four);
    }
    
    public int mask(int n ){
        int res = 0;
        while(n != 0){
            int t = n & 1;
            if(t == 1) res++;
            n = n >> 1;
        }
        return res;
    }
    
}

//https://leetcode.com/problems/counting-bits/submissions/
