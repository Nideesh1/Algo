class Solution {
    public int bitwiseComplement(int N) {
        
        if(N == 0) return 1;
        
       List<Integer> l = new ArrayList<>();
       System.out.println(Integer.toBinaryString(N));
       while( N != 0 ){
           int t = N & 1;
           l.add(0,1 - t);
           N >>= 1;
       }
        System.out.println(l);
        int j = 0;
        while(j < l.size() && l.get(j) == 0){
            j++;
        }
        System.out.println(j);
        int res = 0;
        for(int k = j; k < l.size(); k++){
            res <<= 1;
            res = res | l.get(k);
        }
        System.out.println((int) res);
        return (int) res;
    }
}

//https://leetcode.com/problems/complement-of-base-10-integer/
