class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStk = new Stack<>();
        Stack<StringBuilder> strStk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStk.push(k);
                strStk.push(sb);
                
                k = 0;
                sb = new StringBuilder();
            } else if (c == ']') {
                StringBuilder decode = strStk.pop();
                for (int i = countStk.pop(); i > 0; i--) {
                    decode.append(sb);
                }
                sb = decode;
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}

//https://leetcode.com/problems/decode-string/solution/
