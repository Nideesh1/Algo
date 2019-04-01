class Solution {
    public String largestTimeFromDigits(int[] A) {
        List<List<Integer>> tot = new ArrayList<>();
        boolean[] vis = new boolean[A.length];
        Arrays.sort(A);
        recur(A, tot, new ArrayList<>(), vis);
        //System.out.println(tot);
        int max = Integer.MIN_VALUE;
        for(List<Integer> l : tot){
            max = Math.max(max, valid(l));
        }
        System.out.println(max);
        System.out.println(tot);
        if(max == 0) return "00:00";
        if(max == Integer.MIN_VALUE) return "";
        StringBuilder sb = new StringBuilder(Integer.toString(max));
        if(sb.length() == 3) {sb.insert(0,"0");}
        
        return sb.insert(2,":").toString();
        
    }
    
    public int valid(List<Integer> l){
        int hr = l.get(0) * 10 + l.get(1);
        int mn = l.get(2) * 10 + l.get(3);
        if(hr >= 0 && hr < 24 && mn >= 0 && mn <= 59) return hr*100 + mn;
        return Integer.MIN_VALUE;
    }
    
    public void recur(int[] A,  List<List<Integer>> tot, List<Integer> l, boolean[] vis){
        if(l.size() == A.length){
            tot.add(new ArrayList<>(l)); return;
        }else{
            for(int i = 0; i < A.length; i++){
                if(vis[i] || (i > 0 && A[i] == A[i-1] && !vis[i-1])) continue;
                l.add(A[i]); vis[i] = true;
                recur(A, tot, l, vis);
                l.remove(l.size()-1); vis[i] = false;
            }
        }
    }
}

//https://leetcode.com/problems/largest-time-for-given-digits/
