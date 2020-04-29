class Solution {
    public String entityParser(String text) {
        StringBuilder res = new StringBuilder();
        Map<String, Character> map = new HashMap<>();
        map.put("&quot;", '"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');
        int pointer = 0;
        int n = text.length();
        
        while(pointer < n){
            if(text.charAt(pointer) == '&'){
                StringBuilder inner = new StringBuilder();
                while(pointer < n && text.charAt(pointer) != ';'){
                    inner.append(text.charAt(pointer));
                    pointer++; 
                }
                //include the semi-colon
                inner.append(text.charAt(pointer++));
                
                if(map.containsKey(inner.toString())){
                    res.append(map.get(inner.toString()));
                }else{
                    res.append(inner.toString());
                }
                
                
            }else{
                res.append(text.charAt(pointer++));
            }
        }
        
        return res.toString();
    }
}

