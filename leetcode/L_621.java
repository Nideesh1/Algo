class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;
        
        Arrays.sort(freq);
        
        int maxTaskFreq = freq[25];
        int idleTime = (maxTaskFreq - 1) * n;
        
        for (int i = freq.length - 2; i >= 0 && idleTime > 0; i--) {
            idleTime -= Math.min(freq[i] , maxTaskFreq - 1);
        }
        idleTime = Math.max(0, idleTime);
        
        return idleTime + tasks.length;
    }
}
//https://leetcode.com/problems/task-scheduler/
//https://leetcode.com/articles/task-scheduler/
