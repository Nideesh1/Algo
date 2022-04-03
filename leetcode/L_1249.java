class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> invalid = new HashSet<>();
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stk.push(i);
            } else if (s.charAt(i) == ')') {
                if (stk.isEmpty()) {invalid.add(i);}
                else {stk.pop();}
            }
        }
        while(!stk.isEmpty()) invalid.add(stk.pop());
        StringBuilder sb = new StringBuilder();
        //System.out.println(invalid);
        for (int i = 0; i < s.length(); i++ ){
            if (!invalid.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
