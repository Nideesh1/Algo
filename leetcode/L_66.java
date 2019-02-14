class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int i = digits.length - 1;
        List<Integer> l = new ArrayList<>();
        while( carry > 0 || i >= 0){
            if(i >= 0){
                carry += digits[i];
            }
            l.add(carry%10);
            carry /= 10;
            i--;
        }
        Collections.reverse(l);
        int[] r = new int[l.size()];
        for(int j = 0; j < l.size(); j++){
            r[j] = l.get(j);
        }
        return r;
    }
}

//https://leetcode.com/problems/plus-one/description/
