class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int ori = x;
        Queue<Integer> stk = new LinkedList<>();
        while (x != 0) {
            stk.add(x%10);
            x = x/10;
        }
        int res = 0;
        while (!stk.isEmpty()) {
            //System.out.println(stk.peek());
            res = (res * 10) + stk.poll();
        }
        // System.out.println(ori);
        // System.out.println(res);
        return res == ori;
    }
}
