class Solution {
    public int maxDepth(String s) {
        int res = 0, cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                res = Math.max(res, ++cur);
            } else if (c == ')') {
                cur--;
            }
        }
        return res;
    }
}
