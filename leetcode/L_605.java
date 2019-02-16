//Plant as you go

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0; int count = 0; int l = flowerbed.length;
        while( i < l ){
            
            if( (flowerbed[i] != 1) && (  i == 0 || flowerbed[i-1] == 0) && (i == l-1 || flowerbed[i+1] == 0) ){
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }
}

//https://leetcode.com/problems/can-place-flowers/description/
