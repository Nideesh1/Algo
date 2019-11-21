class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        
        int[] count = new int[26];
        
        for(String s : strs){
             Arrays.fill(count, 0);           
            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i : count){
                sb.append('~');
                sb.append(i);
            }
            String key = sb.toString();
            List<String> l = map.getOrDefault(key, new ArrayList<>());
            l.add(s);
            map.put(key, l);
        }
        return new ArrayList<>(map.values());
    }
}

//https://leetcode.com/problems/group-anagrams/
