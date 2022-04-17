class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
                stk.push(1);
            } else {
                int incremented = stk.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stk.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}

class Solution {
    
    public String removeDuplicates(String s, int k) {
        return dfs(s, 0);
    }
    public String dfs(String s, int i) {
        for (; i < s.length(); i++) {
            if (repeat(s, i)) {
                int anchor = i;
                i += 2;
                while (i < s.length() && s.charAt(anchor) == s.charAt(i)) {i++;}
                String left = s.substring(0, anchor);
                String right = s.substring(i);
                left += right;
                
                String crush = dfs(left, 0);
                String uncrush = dfs(s, i);
                
                return crush.length() < uncrush.length() ? crush : uncrush;
            }
        }
        return s;
    }
    
    public boolean repeat(String s, int i) {
        if (i + 2 < s.length() && s.charAt(i) == s.charAt(i+1) && s.charAt(i) == s.charAt(i+2)) {return true;}
        else return false;
    }
}

//https://gist.github.com/atiwari3bu/6feb336753cfc65d58d8b513a8136ae3
