
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int l = 0, r = arr.length() - 1;
        int peak = 0;
        //find peak. 
        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) < arr.get(m + 1)) {
                l = m + 1;
                peak = l;
            } else {
                r = m - 1;
            }
        }
        r = peak; l = 0; 
        
        //left half of peak binary search
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr.get(m) == target) {return m;}
            else if (target < arr.get(m)) {r = m - 1; }
            else if (target > arr.get(m)) {l = m + 1;}
        }
        l = peak; r = arr.length() - 1;
        //reverse half of peak binary search on the right slope down
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr.get(m) == target) {return m;}
            else if (target < arr.get(m)) {l = m + 1; }
            else if (target > arr.get(m)) {r = m - 1;}
        }   
        return -1;
    }
}
