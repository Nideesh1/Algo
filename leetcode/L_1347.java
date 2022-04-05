class Solution {
    public int minSteps(String s, String t) {
        int[] ar = new int[26];
        // ar[i] positive means t is deficient
        // ar[i] negative means t is suprlus
        for (int i = 0; i < s.length(); i++) {
            ar[s.charAt(i) - 'a']++;
            ar[t.charAt(i) - 'a']--;
        }
        int res = 0;
        for (int a : ar) if (a > 0) res += a;
        return res;
    }
}
