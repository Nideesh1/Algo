class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character,Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        
        map.put('6','9');        
        map.put('8','8');
        map.put('9','6');
        
        
        
        char[] ar = num.toCharArray();
        
        if(ar.length == 1){
            return num.charAt(0) == map.getOrDefault(num.charAt(0), '-');
        }
        int i = 0; int j = ar.length-1;
        
        while( i <= j){
            
            if(map.getOrDefault(ar[i], '-') != ar[j]){
                return false;
            }
            i++; j--;
            
        }
        return true;
    }
}

//https://leetcode.com/problems/strobogrammatic-number/
