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


class Solution {
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    Map<Integer, Integer> sm = computeFrequencyMap(s);
    Map<Integer, Integer> tm = computeFrequencyMap(t);
    System.out.println(sm);
    return sm.equals(tm);
}

private Map<Integer, Integer> computeFrequencyMap(String s) {
    Map<Integer, Integer> sm = new HashMap<>();
    for (int i = 0; i < s.length(); ++i) {
        char cs = s.charAt(i);
        int cp;
        if (i < s.length() - 1 && Character.isHighSurrogate(cs)) {
            char cn = s.charAt(i + 1);
            cp = Character.isLowSurrogate(cn) ? Character.toCodePoint(cs, cn) : cs;
        } else {
            cp = cs;
        }
        i = cp == cs ? i : i + 1;
        sm.put(cp, sm.getOrDefault(cp, 0) + 1);
    }
    return sm;
}
}

//https://leetcode.com/problems/valid-anagram/description/
