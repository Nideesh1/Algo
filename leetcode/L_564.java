class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.valueOf(n);
        int len = n.length();
        int i = len % 2 == 0 ? len /2 - 1 : len/2;
        
        String str = n.substring(0, i + 1);
        long l = Long.valueOf(str);
        List<Long> list = new ArrayList<>();
        
        list.add(help(l, len % 2 == 0));
        list.add(help(l-1, len % 2 == 0));
        list.add(help(l+1, len % 2 == 0));
        list.add((long) Math.pow(10, len - 1) - 1);
        list.add((long) Math.pow(10, len) + 1);
        long pot = 0, diff = Integer.MAX_VALUE;
        for(Long ln : list){
            if(ln == num) continue;
            if(Math.abs(num - ln) < diff){
                diff = Math.abs(num - ln);
                pot = ln;
            }else if(Math.abs(num - ln) == diff){
                pot = Math.min(pot, ln);
            }
        }
        
        return String.valueOf(pot);
    }
    public long help(long l, boolean even){
        long res = l;
        if(!even) l /= 10;
        while(l > 0){
            res = res*10 + l % 10; ; l /= 10;
        }
        return res;
    }
}

//https://leetcode.com/problems/find-the-closest-palindrome/discuss/122957/Java-compare-five-candidates-get-result-easy-to-understand
