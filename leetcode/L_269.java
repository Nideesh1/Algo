class Solution {
    public String alienOrder(String[] words) {
        Map<Character,List<Character>> map = new HashMap<>();
        int[] indegree = new int[26];
        
        Set<Character> seen = new HashSet<>();
        for(String word : words) {
            for (char c : word.toCharArray()) {
                seen.add(c);
            }
        }
        //System.out.println(seen);
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i+1];
            //System.out.println(map);
            // find the first letter abc , adeh which is different and use the shorter length
            int minLen = Math.min(cur.length(), next.length());
            for (int j = 0; j < minLen; j++ ) {
                if (cur.charAt(j) != next.charAt(j)) {
                    List<Character> list = map.getOrDefault(cur.charAt(j), new ArrayList<>());
                    list.add(next.charAt(j));
                    map.put(cur.charAt(j), list);
                    indegree[next.charAt(j) - 'a']++;
                    break;
                }
                // abcd , abc should return false
                if (j == minLen - 1 && next.length() < cur.length()) return "";
            }
        }
        //System.out.println(map);
        
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (Character c : seen) if (indegree[c-'a'] == 0) q.add(c);
        //System.out.println(q);
        while(!q.isEmpty()) {
            Character cur = q.poll();
            sb.append(cur);
            if(!map.containsKey(cur)) continue;
            for (Character nei : map.get(cur)) {
                indegree[nei - 'a']--;
                if (indegree[nei - 'a'] == 0) {
                    q.add(nei);
                }
            }
        }
        return sb.length() == seen.size() ? sb.toString() : "";
    }
}
