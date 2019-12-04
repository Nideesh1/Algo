class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num = new ArrayList<>();
        
        int fact = 1;
        
        for(int i = 1; i <= n; i++){
            fact *= i;
            num.add(i);
        }
        
        System.out.println(fact);
        
        for(int i = 0, l = k - 1; i < n; i++){
            fact /= (n-i);
            int idx = (l / fact);
            
            sb.append(num.remove(idx));
            l -= idx * fact;
        }
        
        
        return sb.toString();
    }
}


//https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
