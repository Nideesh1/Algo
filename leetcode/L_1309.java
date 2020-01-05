class Solution {
    public String freqAlphabets(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            stk.push(c);
        }
        Map<String,Character> map = new HashMap<>();
        int put = 1;
        for(char c = 'a'; c <= 'i'; c++){
            map.put("" + put++, c);
        }
        put = 10;
        for(char c = 'j'; c <= 'z'; c++){
            map.put(put++ + "#", c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        StringBuilder res = new StringBuilder();
        
        while(!stk.isEmpty()){
            sb.append(stk.pop());
            String cur = sb.reverse().toString();
            sb.reverse();
            //System.out.println("out " + cur);
            if(map.containsKey(cur)){
                res.append(map.get(cur));
                sb = new StringBuilder();
            }
        }
        
        
        
        
        return res.reverse().toString();
        
    }
}

