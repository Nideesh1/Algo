class Solution {
    public char[][] rotateTheBox(char[][] box) {
        graivty(box);
        return rotate(box);
    }
    public char[][] rotate(char[][] box) {
        char[][] rotated = new char[box[0].length][box.length];
        for(int r = 0; r < box.length; r++) {
            for(int c = 0; c < box[0].length; c++) {
                rotated[c][box.length - 1 - r] = box[r][c];
            }
        }
        return rotated;
    }
    public void graivty (char[][] box) {
        for (char[] b : box) {
            int pos = b.length - 1;
            for (int i = b.length - 1; i >= 0; i--) {
                if (b[i] == '#') {
                    b[i] = '.';
                    b[pos--] = '#';
                }
                if (b[i] == '*') {
                    pos = i - 1;
                }
            }
        }
    }
}
