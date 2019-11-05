/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cel = 0;
        for(int i = 0; i < n; i++) if(knows(cel, i)) cel = i;
        for(int i = 0; i < n; i++) if (cel != i && knows(cel, i)) return -1;
        for(int i = 0; i < n; i++) if(cel != i && !knows(i, cel)) return -1;
        return cel;
    }
}

//https://leetcode.com/problems/find-the-celebrity/
//https://leetcode.com/problems/find-the-celebrity/discuss/71228/JavaPython-O(n)-calls-O(1)-space-easy-to-understand-solution
