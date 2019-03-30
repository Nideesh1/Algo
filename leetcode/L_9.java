class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        List<Integer> l = new ArrayList<>();
        while(x != 0){
            l.add(x%10);
            x /= 10;
        }
        for(int i = 0; i < l.size()/2; i++){
            if(l.get(i) != l.get(l.size()-1-i)){
                return false;
            }
        }
        return true;
    }
}

//https://leetcode.com/problems/palindrome-number/
