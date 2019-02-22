//Count the frequency of the previous numbers one by one and and Say it loudly. This'll be the next number.

class Solution {
    public String countAndSay(int n) {
        StringBuilder cur = new StringBuilder("1");
        StringBuilder prev;
        int count; char say;
        for(int i = 1; i < n; i++){
            prev = cur;
            cur = new StringBuilder();
            count = 1;
            say = prev.charAt(0);
            
            for(int j = 1, len = prev.length(); j < len; j++){
                    if (prev.charAt(j)!=say){
                        cur.append(count).append(say);
                        count=1;
                        say=prev.charAt(j);
                    }
                    else count++;
            }
            
            cur.append(count).append(say);
        }
        return cur.toString();
    }
}
