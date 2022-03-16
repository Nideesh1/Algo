class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStk = new Stack<>();
        Stack<StringBuilder> strStk = new Stack<>();
        int k = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                intStk.push(k); k = 0;
                strStk.push(sb); sb = new StringBuilder();
            } else if (c == ']') {
                int num = intStk.pop();
                StringBuilder temp = strStk.pop();
                for (int i = num; i > 0; i--) {
                    temp.append(sb);
                }
                sb = temp;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
