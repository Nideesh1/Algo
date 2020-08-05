class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        Map<Character,Integer> mapA = new HashMap<>();
        List<Integer> pos = new ArrayList<>();
        for(int i = 0; i < A.length(); i++){
            char a = A.charAt(i);
            char b = B.charAt(i);
            
            if(a != b) pos.add(i);
            
            mapA.put(a, mapA.getOrDefault(a, 0) + 1);           
        }
        if(A.equals(B)){
            for(Character c : mapA.keySet()) {if(mapA.get(c) > 1) return true;}
            return false;
        }
        
        if(pos.size() != 2) return false;
        int posOne = pos.get(0);
        int posTwo = pos.get(1);
        return A.charAt(posOne) == B.charAt(posTwo) && A.charAt(posTwo) == B.charAt(posOne);
    }
}


//https://leetcode.com/problems/buddy-strings/description/
