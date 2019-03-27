public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        List<Integer> l = new ArrayList<>();
        int time = 32;
        while(time != 0){
            int t = n & 1;
            l.add(0, t);
            n >>= 1;
            time--;
        }
    
        for(int i = l.size() - 1; i >= 0; i--){
            res <<= 1;
            res = res | l.get(i);

        }
        
        
        return res;
    }
}

//https://leetcode.com/problems/reverse-bits/
