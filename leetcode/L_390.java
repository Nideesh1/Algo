// f(n, left) n starting from left
// f(n, right) n starting from right
// f(n, left) + f(n, right) = n + 1
// f(n, left) = (n + 1) - f(n, right);
// f(n, left) =  2* [(n + 1) - f(n/2, right)];

class Solution {
    public int lastRemaining(int n) {
        if (n == 1) return 1;
        return 2 * ((n/2 + 1) -  lastRemaining(n / 2));
    }
}

