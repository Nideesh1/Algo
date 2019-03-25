class Solution {
    public int countPrimeSetBits(int L, int R) {
        System.out.println(set(21));
        
        boolean[] pr = new boolean[32 + 1];
        for(int i = 1; i < pr.length; i++){
            pr[i] = true;
        }
        
        for(int i = 2; i*i <= 32; i++){
            if(pr[i] == true){
                for(int j = i*i; j<= 32; j = j + i){
                    pr[j] = false;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 2; i < pr.length; i++){
            if(pr[i]){
                set.add(i);
            }
        }
        int res= 0;
        for(int i = L; i <= R; i++){
            if(set.contains(set(i))){
                res++;
            }
        }
        
        return res;
    }
    
    public int set(int i){
        int res = 0;
        while( i != 0){
            int t = i & 1;
            res += t == 1 ? 1 : 0;
            i = i >> 1;
        }
        return res;
    }
}

//https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
