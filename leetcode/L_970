class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 24; j++) {
                int num = (int)(Math.pow(x, i) + Math.pow(y, j));
                if (!set.contains(num) && num <= bound) {
                    ans.add(num);
                    set.add(num);
                }
            }
        }
        return ans;
    }
}

//https://leetcode.com/problems/powerful-integers/
