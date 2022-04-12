class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int res = 0;
        Arrays.sort(freq);
        int maxFreq = s.length();
        for (int i = freq.length - 1; i >= 0; i--) {
            if (freq[i] > 0) {
                if (freq[i] > maxFreq) {
                    res += freq[i] - maxFreq;
                    freq[i] = maxFreq;
                }
            }
            maxFreq = Math.max(0, freq[i] - 1);
        }
        return res;
    }
}
