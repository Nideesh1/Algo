class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> res = new ArrayList<>();   
        String[] ar = ip.split("\\.");
        long x = 0;
        for(int i = 0; i < ar.length; i++){
            x  = Integer.parseInt(ar[i]) + x * 256;
        }
        
        while(n != 0){
            long step = (int) (x & -x);
            while(step > n) step /= 2;
            res.add(ip(x, (int) step));
            x += step;
            n -= step;
        }
        
        return res;
    }
    
    public String ip(long x, int step){
        int[] ar = new int[4];
        ar[0] = (int) (x & 255); x >>= 8;
        ar[1] = (int) (x & 255); x >>= 8;
        ar[2] = (int) (x & 255); x >>= 8;
        ar[3] = (int) (x & 255); x >>= 8;
        int len = 33;
        while(step > 0){
            len--;
            step /= 2;
        }
        return ar[3] + "."+ ar[2] + "." +ar[1] + "." +ar[0] + "/" + len;
    }
}

//https://leetcode.com/problems/ip-to-cidr/
