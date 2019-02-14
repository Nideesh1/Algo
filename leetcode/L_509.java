class Solution {
    public int fib(int N) {
        Map<Integer,Integer> m = new HashMap<>();
        return fib(N, m);
    }
    public int fib(int N, Map<Integer,Integer> m){
        if(N == 0 || N == 1){return N;}
        if(m.containsKey(N))
        {return m.get(N);}
        m.put(N, fib(N-1, m) + fib(N-2, m));
        return m.get(N);
    }
}

//https://leetcode.com/problems/fibonacci-number/description/
