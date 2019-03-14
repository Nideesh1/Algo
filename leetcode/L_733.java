class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int num = image[sr][sc];
        if(newColor == num) return image;
        recur(image, sr, sc, newColor, num);
        return image;
    }
    
    public void recur(int[][] image, int sr, int sc, int newColor, int num){
        if(out(image, sr, sc) || image[sr][sc] != num){
            return;
        }
        image[sr][sc] = newColor;
        recur(image, sr+1, sc, newColor, num);
        recur(image, sr-1, sc, newColor, num);
        recur(image, sr, sc+1, newColor, num);        
        recur(image, sr, sc-1, newColor, num);        
    }
    

    
    public boolean out(int[][] image, int sr, int sc){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return true;
        return false;
    }
}

//https://leetcode.com/problems/flood-fill/
