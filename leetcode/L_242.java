class Solution {
    public boolean isAnagram(String s, String t) {
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        qsort(S, 0, S.length-1);
        qsort(T, 0, T.length-1);
        s = new String(S); t = new String(T);
        return s.equals(t);
    }
    
    public void qsort(char[] A, int l, int r){
        if(l < r){
            int ind = part(A, l, r);
            qsort(A, l, ind-1);
            qsort(A, ind+1, r);
        }
    }
    public int part(char[] A, int l, int r){
        int i = l-1; char pivot = A[r];
        for(int j = l; j < r; j++){
            if(A[j] < pivot){
                i++;
                char t= A[i]; A[i] = A[j]; A[j] = t;
            }
        }
        char t1 = A[i+1]; A[i+1] = pivot; A[r] = t1;
        return i+1;
    }
}

//https://leetcode.com/problems/valid-anagram/description/
