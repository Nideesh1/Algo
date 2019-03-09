class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for(String s : A){
            //this map count the chars occurring in even and odd places thats 
            //why the map size is 52
            int[] map = new int[52];
            for(int i = 0; i < s.length(); i++){
                map[s.charAt(i) - 'a' + 26 * (i%2)]++;
            }
            set.add(Arrays.toString(map));
        }
        return set.size();
    }
}

//https://leetcode.com/problems/groups-of-special-equivalent-strings/
