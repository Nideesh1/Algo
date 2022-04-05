class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((target - sum ) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }
}
