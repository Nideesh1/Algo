class Solution {
    public boolean isLongPressedName(String name, String typed) {
        Group g1 = group(name);
        Group g2 = group(typed);
        
        if(!g1.key.equals(g2.key)){return false;}
        for(int i = 0; i < g1.count.size(); i++){
            if(g2.count.get(i) < g1.count.get(i) ){
                return false;
            }
        }
        return true;
    }
    
    public Group group(String s){
        StringBuilder sb = new StringBuilder();
        List<Integer> count = new ArrayList<>();
        int anchor = 0; int n = s.length();
        for(int i = 0; i < n; i++){
            if(i == n-1 || s.charAt(i) != s.charAt(i+1)){
                sb.append(s.charAt(i));
                count.add(i+1 - anchor);
                anchor = i + 1;
            }
        }
        return new Group(sb.toString(), count);
    }
}

class Group {
    public String key;
    public List<Integer> count;
    public Group(String key, List<Integer> count){
        this.key = key;
        this.count = count;
    }
}

//https://leetcode.com/problems/long-pressed-name/description/
