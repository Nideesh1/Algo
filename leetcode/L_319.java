class Solution {
    public int bulbSwitch(int n) {
        int count = 0;
        for(int i = 1; i * i <= n; i++){
            count++;
        }
        return count;
    }
}
class Solution {
    public int bulbSwitch(int n) {
        int[] ar = new int[n];
        Arrays.fill(ar,1);
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j = j + i + 1){
                ar[j] = 1 - ar[j];
            }
            //System.out.println(Arrays.toString(ar));
        }
        int count = 0;
        for(int i : ar) if(i == 0)count++;
        return count;
    }
}

//https://leetcode.com/problems/bulb-switcher/
