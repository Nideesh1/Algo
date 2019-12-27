public class Solution {
    // you need treat n as an unsigned value
     public int reverseBits(int n) {
            int ret=n;
            ret = ret >>> 16 | ret<<16;
            ret = (ret & 0xff00ff00) >>> 8 | (ret & 0x00ff00ff) << 8;
            ret = (ret & 0xf0f0f0f0) >>> 4 | (ret & 0x0f0f0f0f) << 4;
            ret = (ret & 0xcccccccc) >>> 2 | (ret & 0x33333333) << 2;
            ret = (ret & 0xaaaaaaaa) >>> 1 | (ret & 0x55555555) << 1;
            return ret;
    }
}

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
