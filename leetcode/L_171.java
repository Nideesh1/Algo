class Solution {
    public int titleToNumber(String s) {
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i = 97; i <= 96 + 26; i++){
            map.put(Character.toUpperCase((char) i), i - 96);
        }
        //System.out.println(map);
        int res = 0;
        int pow = 1;
        for(int i = s.length()-1; i >= 0; i--){
            res += pow*map.get(s.charAt(i));
            pow = pow * 26;
        }
       
        System.out.println(res);
        return res;
    }
}

//https://leetcode.com/problems/excel-sheet-column-number/
