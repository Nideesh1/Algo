class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ar1 = version1.split("\\.");
        String[] ar2 = version2.split("\\.");
        int max = Math.max(ar1.length, ar2.length);
        
        for(int i = 0; i < max; i++){
            Integer v1 = i < ar1.length ? Integer.parseInt(ar1[i]) : 0;
            Integer v2 = i < ar2.length ? Integer.parseInt(ar2[i]) : 0;
            
            int temp = v1.compareTo(v2);
            if(temp != 0){
                return temp;
            }
            
        }
        return 0;
    }
}

//https://leetcode.com/problems/compare-version-numbers/discuss/50774/Accepted-small-Java-solution.
