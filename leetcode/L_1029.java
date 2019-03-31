class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> b = new ArrayList<>();
        int start = A[0];
            if(start % 5 == 0) {b.add(true);}
            if(start % 5 != 0) {b.add(false);}
        for(int i = 1; i < A.length; i++){
            if(A[i] == 1){
                start = start * 2 + 1;
            }else{
                start = start * 2;
            }
            if(start % 5 == 0) {b.add(true);}
            if(start % 5 != 0) {b.add(false);}
            start = start % 5;
        }
        return b;

        
    }
}

//https://leetcode.com/problems/binary-prefix-divisible-by-5/
