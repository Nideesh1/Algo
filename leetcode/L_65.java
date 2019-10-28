//trick to the problem is order of importance
// number
// dot
// e [reset number when you see e]
// +/- [e can have a + or - after it]

class Solution {
    public boolean isNumber(String s) {
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        s = s.trim();
        for(int i = 0; i < s.length(); i++){
            if('0' <= s.charAt(i) && s.charAt(i) <= '9' ){
                numSeen = true;
            }
            else if(s.charAt(i) == '.'){
                if(dotSeen || eSeen){
                    return false;
                }
                dotSeen = true;
            }
            else if(s.charAt(i) == 'e'){
                if(eSeen || !numSeen){
                    return false;
                }
                numSeen = false;
                eSeen = true;
            }
            else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(i != 0 && s.charAt(i-1) != 'e'){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return numSeen;
    }
}

//https://leetcode.com/problems/valid-number/
//https://leetcode.com/problems/valid-number/discuss/23738/Clear-Java-solution-with-ifs
