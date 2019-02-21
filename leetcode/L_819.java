class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> map = build(paragraph);

        for(String s : banned){
            map.remove(s);
        }
        map.remove("");
        int max = 0;
        String res = "";
        for(String s : map.keySet()){
            if(map.get(s) > max){
                max = Math.max(max, map.get(s));
                res = s;
            }
        }
        return res;
    }
    public Map<String,Integer> build(String para){
        Map<String,Integer> res = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(Character c : para.toCharArray()){

            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }else{
                int count = res.getOrDefault(sb.toString(), 0) + 1;
                res.put(sb.toString(), count);
                sb.setLength(0);
            }
        }

        if(sb.length() != 0){
            res.put(sb.toString(), 1);
        }
        

        return res;
    }
}

//https://leetcode.com/problems/most-common-word/description/
