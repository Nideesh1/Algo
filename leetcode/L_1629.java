class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDiff = releaseTimes[0];
        char res = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int diff = releaseTimes[i] - releaseTimes[i-1];
            char c = keysPressed.charAt(i);
            if (diff > maxDiff ||
               (diff == maxDiff && c > res)) {
                maxDiff = diff;
                res = c;
            }
        }
        return res;
    }
}
