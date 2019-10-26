class Solution {
    public String simplifyPath(String path) {
        Deque<String> stk = new LinkedList<>();
        Set<String> skip = new HashSet<>();
        skip.add(".."); skip.add("."); skip.add("");
        for(String dir : path.split("/")){
            if(dir.equals("..") && !stk.isEmpty()){
                stk.pop();
            }else if(!skip.contains(dir)){
                stk.push(dir);
            }
        }
        System.out.println(stk);
        String res = "";
        for(String s : stk){
            res = "/" + s + res;
        }

        return res.isEmpty() ? "/" : res;
    }
}

//https://leetcode.com/problems/simplify-path/
//https://leetcode.com/problems/simplify-path/discuss/25686/Java-10-lines-solution-with-stack
