class Solution {
    public boolean judgeCircle(String moves) {
        int x= 0; int y = 0;
        for(Character c : moves.toCharArray()){
            if(c == 'U'){y++;}
            if(c == 'D'){y--;}
            if(c == 'L'){x--;}
            if(c == 'R'){x++;}            
        }
        return x == 0 && y == 0;
    }
}

//https://leetcode.com/problems/robot-return-to-origin/description/
