//Sieve of 
class Solution {
    public int countPrimes(int n) {
        boolean[] pr = new boolean[n+1];
        for(int i = 0; i < pr.length; i++){
            pr[i] = true;
        }
        
        for(int i = 2; i*i <= n; i++){
            
            if(pr[i]){
                for(int j = i*i; j <= n; j = j + i){
                    pr[j] = false;
                }
            }   
        }
        int res = 0;
        for(int i = 2 ; i < pr.length-1; i++){
            if(pr[i]) res++;
        }
        return res;
    }
    
}

//https://leetcode.com/problems/count-primes/
