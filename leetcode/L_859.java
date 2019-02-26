class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length())return false;
        boolean Arepeat = false; boolean Brepeat = false;
        Set<Character> Aset = new HashSet<>();
        Set<Character> Bset = new HashSet<>();
        List<Integer> pos = new ArrayList<>();
        for(int i = 0; i < A.length(); i++){
            char a = A.charAt(i);
            char b = B.charAt(i);
            if(Aset.contains(a)){Arepeat = true;}
            if(Bset.contains(b)){Brepeat = true;}
            if(A.charAt(i) != B.charAt(i)){
                pos.add(i);
            }
            Aset.add(a); Bset.add(b);
        }
        
        //A's pos 0 has to equal B's pos 1
        //A's pos 1 has to equal B's pos 0
        if(pos.size() == 2){
            if(A.charAt(pos.get(0)) == B.charAt(pos.get(1)) && A.charAt(pos.get(1)) == B.charAt(pos.get(0))){
                return true;
            }
        }
        
        if(A.equals(B) && Arepeat && Brepeat){return true;}
        return false;
    }
}


//https://leetcode.com/problems/buddy-strings/description/
