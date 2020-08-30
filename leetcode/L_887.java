//TLE
class Solution {
    public int superEggDrop(int K, int N) {
        int eggs = K;
        int floors = N;
        return dfs(eggs, floors);
    }
    public int dfs(int eggs, int floors){
        if(floors <= 1) return floors;
        if(eggs == 1) return floors;
        
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= floors; i++){
                
            int one = dfs(eggs - 1, i - 1); // below floor i
            int two = dfs(eggs, floors - i);// above floor i
            
            res = Math.min(res, Math.max(one, two));
            
        }
        return res + 1;
    }
}

class Solution {
    public int superEggDrop(int K, int N) {
        int[][] memo = new int[K + 1][N + 1];
        return helper(K, N, memo);
    }
    private int helper(int K, int N, int[][] memo) {
        if (N <= 1) {
            return N;
        }
        if (K == 1) {
            return N;
        }
        if (memo[K][N] > 0) {
            return memo[K][N];
        }
        
        int low = 1, high = N, result = N;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int left = helper(K - 1, mid - 1, memo);
            int right = helper(K, N - mid, memo);
            result = Math.min(result, Math.max(left, right) + 1);
            if (left == right) {
                break;
            } else if (left < right) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        memo[K][N] = result;
        return result;
    }
}
