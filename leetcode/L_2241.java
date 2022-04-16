class ATM {
    long[] denom = {20,50,100,200,500};
    long[] atm;
    public ATM() {
        atm = new long[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < atm.length; i++) {
            atm[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] res = new int[5];
        int p = 4;
        while (p >= 0 && amount> 0) {
            res[p] = (int) Math.min((amount) / denom[p], atm[p]);
            amount -= res[p] * denom[p];
            p--;
        }
        if (amount != 0) return new int[]{-1};
        for (int i = 0; i < atm.length; i++) {
            atm[i] -= res[i];
        }
        return res;
    }
}

//https://leetcode.com/problems/design-an-atm-machine/discuss/1954188/Design-an-ATM-Machine-or-Java-Solution
