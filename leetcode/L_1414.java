class Solution {
    Map<Integer,Integer> fib = new HashMap<>();
    
    public int findMinFibonacciNumbers(int k) {
        List<Integer> pos = new ArrayList<>();
        int n = 1;
        while(fib(n) <= k){
            pos.add(fib(n++));
        }
        int pointer = pos.size() - 1;
        int res = 0;
        while(k != 0 && pointer >= 0){
            int cur = pos.get(pointer--);
            //System.out.println(cur);
            if(k >= cur){
                k -= cur; res++;
            }
            //System.out.println(k);
        }
        System.out.println(pos);
        return res;
    }
    
    int fib(int n ){
        if(n == 1 || n == 2) return 1;
        if(fib.containsKey(n)) return fib.get(n);
        int res = fib(n - 1) + fib(n - 2); fib.put(n, res);
        return res;
    }
}

