class Solution {
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }
        for(int i = 0; i < arr.length; i++){
            for(char c = '9'; c >= '0'; c--){
                int ind = map.getOrDefault(c, -1);
                if(c > arr[i] && ind > i){
                    char t = arr[i];
                    arr[i] = arr[ind];
                    arr[ind] = t;
                    return Integer.valueOf(new String(arr));
                }
            }
        }
        return num;
    }
}

