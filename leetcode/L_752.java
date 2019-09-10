class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        Set<String> vis = new HashSet<>();
        for(String d : deadends) dead.add(d);
        if(dead.contains("0000")) return -1;
        vis.add("0000");
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                String cur = q.poll();
                if(cur.equals(target)) return res;
                for(String s : nei(cur,dead,vis)){
                    q.add(s);
                }
            }
            res++;
        }
        return -1;
    }
    
    public List<String> nei(String cur, Set<String> dead, Set<String> vis){
        List<String> res= new ArrayList<>();
        char[] ar = cur.toCharArray();
        for(int i = 0; i < 4; i++){
            char c = ar[i];
            
            //left
            ar[i] = c == '0' ? '9' : (char) (c - (char) 1);
            String l = new String(ar);
            if(!dead.contains(l) && !vis.contains(l)){
                vis.add(l); res.add(l);
            }
            //right
            ar[i] = c == '9' ? '0' : (char) (c + (char) 1);
            String r = new String(ar);
            if(!dead.contains(r) && !vis.contains(r)){
                vis.add(r); res.add(r);
            }
            
            ar[i] = c;
            
        }
        return res;
    }
}
//https://leetcode.com/problems/open-the-lock/
//https://leetcode.com/problems/open-the-lock/discuss/305535/Java-BFS-solution-with-comments-(64ms-39.4MB)
