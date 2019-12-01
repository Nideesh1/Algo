class Solution extends SolBase {
    public int rand10() {
        int row, col, idx;
        do{
            row = rand7();
            col = rand7();
            idx = (col - 1)*7 + row;
        }
        while( idx > 40 );
        return 1 + (idx - 1) % 10;
    }
}

//https://leetcode.com/problems/implement-rand10-using-rand7/solution/
