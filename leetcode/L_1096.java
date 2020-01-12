class Solution {
    
    Set<String> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    Stack<String> stk = new Stack<>();
    List<String> res = new ArrayList<>();
    
    public List<String> braceExpansionII(String expression) {
        stk.push(expression);
        dfs();
        Collections.sort(res);
        return res;
    }
    
    public void dfs(){
        while(!stk.isEmpty()){
            String cur = stk.pop();
            //saving answers
            if(cur.indexOf('{') == -1){
                
                
                if(!set.contains(cur)){
                    set.add(cur);
                    res.add(cur);
                }
                continue;
            }
            
            int i = 0, l = 0, r = 0;
            
            while(cur.charAt(i) != '}'){
                if(cur.charAt(i++) == '{'){
                    l = i - 1;
                }
            }
            r = i;
            
                        
            String before = cur.substring(0, l);
            String after = cur.substring(r+1);
            String[] args = cur.substring(l+1, r).split(",");
            
            for(String a : args){
                sb.setLength(0);
                sb.append(before).append(a).append(after);
                stk.push(sb.toString());
            }
        }
    }
}

//https://leetcode.com/problems/brace-expansion-ii/discuss/348541/JAVA-iter_dfs-36ms
