class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        int i = num1.length()-1;
        int j = num2.length()-1;
        while(carry > 0 || i >= 0 || j >= 0){
            int one = 0; int two = 0;
            if(i >= 0){
                one = num1.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                two = num2.charAt(j) - '0';
                j--;
            }
            carry += one; carry += two;
            sb.append(carry%10);
            carry /= 10;
        }
        System.out.println(sb.toString());
        return sb.reverse().toString();
    }
}

//https://leetcode.com/problems/add-strings/
