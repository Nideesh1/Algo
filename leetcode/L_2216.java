class Solution {
    public int minDeletion(int[] nums) {
        int pre = -1, res = 0;
        for (int i : nums) {
            if (pre == i) {
                res++;
            } else {
                pre = pre < 0 ? i : -1;
            }
        }
        return pre < 0 ? res :res + 1;
    }
}

//https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/discuss/1887031/JavaC%2B%2BPython-O(1)-Greedy-Solution-with-Explanation
