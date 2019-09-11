class Solution {
    public int kSimilarity(String A, String B) {
        Set<String> vis = new HashSet<>();
        vis.add(A); 
        int res = 0;
        Queue<String> q = new LinkedList<>(); q.add(A);
        while(!q.isEmpty()){
            int size = q.size(); 
            for(int i = 0; i < size; i++){
                String cur = q.poll(); if(cur.equals(B)) return res;
                for(String s : nei(cur, B, vis)){
                    q.add(s);
                }
            }
        res++;
        }
        return res;
    }
    public List<String> nei(String A, String B, Set<String> vis){
        List<String> res = new ArrayList<>();
        int i = 0;
        while(A.charAt(i) == B.charAt(i)) i++;
        for(int j = i+1; j < A.length(); j++){
            if(A.charAt(j) == B.charAt(j) || A.charAt(i) != B.charAt(j)) continue;
            char[] ar = A.toCharArray();
            char t= ar[i]; ar[i] = ar[j]; ar[j] = t;
            String tem = new String(ar);
            if(vis.add(tem)) res.add(tem);
        }
        return res;
    }
}

//https://leetcode.com/problems/k-similar-strings/
//https://leetcode.com/problems/k-similar-strings/discuss/140099/JAVA-BFS-32-ms-cleanconciseexplanationwhatever
