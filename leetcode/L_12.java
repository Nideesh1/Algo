class Solution {
    public String intToRoman(int num) {
        String[] m = {"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] t = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] o = {"", "I", "II", "III", "IV", "V", "VI","VII", "VIII", "IX", "X"};
        return m[num/1000] + c[(num%1000)/100] + t[(num%100)/10] + o[num%10];
    }
}

//https://leetcode.com/problems/integer-to-roman/discuss/6274/Simple-Solution
