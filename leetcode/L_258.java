class Solution {
    public int addDigits(int num) {
        while(num/10 != 0){
            int t = num;
            int o = 0;
            while(t != 0){
                o += t % 10;
                t /= 10;
            }
            num = o;
        }
        return num;
    }
}

//https://leetcode.com/problems/add-digits/submissions/
