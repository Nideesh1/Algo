class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new 
            HashMap<>();
        
        for(char c : s.toCharArray()){
            int t = map.getOrDefault(c,0) + 1;
            map.put(c,t);
        }
        
        int res  = 0;
        boolean single = false;

        for(Character c : map.keySet()){
            if(map.get(c) % 2 != 0){
                single = true;
                res += map.get(c) - 1;
            }else{
                res += map.get(c);
            }
        }
        
        return single ? res + 1: res;
    }
}

//https://leetcode.com/problems/longest-palindrome/
