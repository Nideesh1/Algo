class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stk = new Stack<>();
        HashMap<Character,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), i);
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                
                while(!stk.isEmpty() && c < stk.peek() && map.get(stk.peek()) > i){
                    set.remove(stk.pop());
                }
                
                stk.push(c);
                set.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : stk) sb.append(c);
        return sb.toString();
    }
}

//https://leetcode.com/problems/remove-duplicate-letters/solution/
