class Solution {
    public boolean hasAlternatingBits(int n) {
        List<Integer> l = new ArrayList<>();
        while(n != 0){
            int t = n & 1;
            l.add(t);
            n = n >> 1;
        }
        if(l.size() == 1) return true;
        for(int i = 1; i < l.size(); i++){
            if(l.get(i) == l.get(i-1)){
                return false;
            }
        }
        return true;
    }
}

//https://leetcode.com/problems/binary-number-with-alternating-bits/
