class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        int i = 0; int j = 0; int n = S.length();
        List<List<Integer>> res = new ArrayList<>();
        while( j < n){
            while(j < n && S.charAt(i) == S.charAt(j)){ ++j; }
            if( j - i >= 3) {
                List<Integer> l = new ArrayList<>(); l.add(i); l.add(j-1);
                res.add(new ArrayList<>(l));
            }
            i = j;
        }
        return res;
    }
}

//https://leetcode.com/problems/positions-of-large-groups/description/
