class Solution {
    public int countSegments(String s) {
        if(s.length() == 0) return 0;
        String[] ar = s.split(" ");
        System.out.println(Arrays.toString(ar));
        int count = 0;
        for(String t : ar){
            if(!t.equals("")){count++;}
        }
        return count;
    }
}

//https://leetcode.com/problems/number-of-segments-in-a-string/description/
