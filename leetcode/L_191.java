public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i <= 256; i++){
            map.put(i, setBits(i));
        }
        
        int one = (int) n & 255; n = n >> 8;
        int two = (int) n & 255; n = n >> 8;
        int three = (int) n & 255; n = n >> 8;
        int four = (int) n & 255; n = n >> 8;
        
        
        
        return map.get(one) + map.get(two) + map.get(three) + map.get(four);
    }
    
    public int setBits(int n){
        int res = 0;
        int t = 0;
        while(n != 0){
            t = n & 1;
            if(t == 1) res++;
            n = n >> 1;
        }
        return res;
    }
}

//https://leetcode.com/problems/number-of-1-bits/
