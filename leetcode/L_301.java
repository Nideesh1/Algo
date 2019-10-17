class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        boolean foundLevel = false;
        q.add(s); vis.add(s);
        while(!q.isEmpty()){
            String cur = q.poll();
            if(valid(cur)){
                res.add(cur); foundLevel = true;
            }
            if(foundLevel) continue;
            for(int i = 0; i < cur.length(); i++){
                if(cur.charAt(i) != '(' && cur.charAt(i) != ')')continue;
                
                String c = cur.substring(0,i) + cur.substring(i+1);
                if(!vis.contains(c)){
                    vis.add(c); q.add(c);
                }
            }
        }
        return res;
    }
    public boolean valid(String s){
        int count = 0;
        char[] ar = s.toCharArray();
        for(char c : ar){
            if(c == '(') count++;
            if(c == ')') count--;
            if(count < 0)break;
        }
        return count == 0;
    }
}

//https://leetcode.com/problems/remove-invalid-parentheses/
//https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution
