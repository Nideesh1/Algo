class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        Stack<Integer> stk = new Stack<>();
        for(int i = bits.length -1; i >= 0; i--){
            stk.push(bits[i]);
        }
        Set<String> set = new HashSet<>(); set.add("0"); set.add("10"); set.add("11");
        String temp = "";
        while(stk.size() != 0){
            temp += stk.pop().toString();
            if(temp.length() > 2 && !set.contains(temp)){return false;}
            if(temp.length() <= 2 && set.contains(temp)){ 
                if(stk.size() == 0  && temp.length() == 1){return true;}
                if(stk.size() == 0 && temp.length() == 2){return false;}
                temp = "";
            }


        }

        return false;
    }
}

//https://leetcode.com/problems/degree-of-an-array/description/
