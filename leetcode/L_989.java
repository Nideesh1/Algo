class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int carry = K;
        int n = A.length;
        
        List<Integer> res = new ArrayList<>();
        int i = n-1; // the pointer to the end of A
        while(i >= 0 || carry > 0){
            if( i >= 0){
                carry += A[i];
            }
            res.add(carry%10);
            carry /= 10;
            i--;
        }
        Collections.reverse(res);
        return res;
    }
}

//https://leetcode.com/problems/add-to-array-form-of-integer/description/
