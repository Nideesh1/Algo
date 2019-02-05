/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int i = 0; int j = n;
        while(i <= j){
            int m = i + (j-i)/2;
            if(isBadVersion(m)){j = m-1 ;}
            if(!isBadVersion(m)){i = m+1 ;}            
        }
        return i;
    }
}

//https://leetcode.com/problems/first-bad-version/description/
