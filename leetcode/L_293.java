class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        int level = 0;
        int pos = 0;
        StringBuilder sb = new StringBuilder(s);
        recur(res, level, pos, sb);
        return res;
    }
    
    public void recur(List<String> res, int level, int pos, StringBuilder sb){
        if(level ==1 ){
            res.add(sb.toString());
            return;
        }
        for(int i = pos; i < sb.length()-1; i++){
            if("++".equals(sb.substring(i, i+2))){
                sb.replace(i, i+2, "--");
                recur(res, level +1 , pos + 1, sb);
                sb.replace(i, i+2, "++");
            }
        }
        return;
    }
}

//https://leetcode.com/problems/flip-game/description/
