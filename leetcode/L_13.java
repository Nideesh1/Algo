class Solution {
    public int romanToInt(String s) {
        if( s == null || s.length() == 0){return 0;}
        
        Map<Character,Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10); map.put('L', 50); map.put('C', 100); map.put('D', 500); map.put('M', 1000); 
    
        int res = 0; int len = s.length();
        res = map.get(s.charAt(len-1));
        
        for(int i = len -2; i >= 0; i--){
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1))){
                res += map.get(s.charAt(i));
            }else{
                res -= map.get(s.charAt(i));
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/roman-to-integer/description/
