class Solution {
    public boolean primeSubOperation(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        if (n == 1) return true;
        for (int i : nums) max = Math.max(max, i);
        boolean[] primes = new boolean[max + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i * i <= max; i++) {
            if (primes[i]) {
                for (int j = i*i; j <= max; j += i) {
                    primes[j] = false;
                }
            }
        }

        for (int i = 0; i < n; i ++) {
            if (i == 0) {
                for (int j = nums[i]-1; j >= 2; j--) {
                    if (primes[j]) {
                        nums[i] = nums[i] - j;
                        break;
                    }
                }
            } else {
                for (int j = nums[i]-1; j >= 2; j--) {
                    if (primes[j] && nums[i-1] < nums[i] - j) {
                        nums[i] = nums[i] - j;
                        break;
                    }
                }     
                if (nums[i-1] >= nums[i]) {
                        return false;
                }           
            }
        }

        return true;
    }
}
