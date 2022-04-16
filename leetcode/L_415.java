class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = num1.length() - 1, p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int one = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int two = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int val = one + two + carry;
            sb.append(val % 10);
            carry = val / 10;
            p1--;
            p2--;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
