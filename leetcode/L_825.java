class Solution {
    public int numFriendRequests(int[] ages) {
        int[] counts = new int[121];
        for(int i : ages){
            counts[i]++;
        }
        int res = 0;
        for(int a = 1; a <= 120; a++){
            
            int ac = counts[a];
            
            for(int b = 1; b <= 120; b++){
                int bc = counts[b];
                
                if(b <= 0.5* a + 7)continue;
                if(b > a)continue;
                if(b > 100 && a < 100) continue;
                
                res += ac * bc;
                if(a == b)res -= ac;
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/friends-of-appropriate-ages/
//https://leetcode.com/problems/friends-of-appropriate-ages/solution/
