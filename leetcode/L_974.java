class Solution {
    public int subarraysDivByK(int[] A, int K) {
        //There K mod groups 0...K-1
        //For each prefix sum that does not have remainder 0 it needs to be paired with 1 with the same remainder
        //this is so the remainders cancel out.
        int N = A.length;
        int[] modGroups = new int[K];
        int sum = 0;
        for (int i = 0; i < N; i++){
            sum += A[i];
            int group = sum % K;
            
            if (group < 0) group += K; //Java has negative modulus so correct it
            modGroups[group]++;
        }
        
        int total = 0;
        for (int x : modGroups){
             if (x > 1) total += (x*(x-1)) / 2;
        }
        //Dont forget all numbers that divide K
        return total + modGroups[0];
    }
}

//Credit to https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/217962/Java-Clean-O(n)-Number-Theory-%2B-Prefix-Sums
