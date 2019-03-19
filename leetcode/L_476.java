class Solution {
    public int findComplement(int num) {
        System.out.println(Integer.toBinaryString(num));
        int size = 0; int backup = num;
        while(backup != 0){
            int t = backup & 1;
            backup = backup >> 1;
            size++;
        }
        System.out.println(size);
        
        num = ~num;
          System.out.println(Integer.toBinaryString(num));      
        int res = 0;
//         while(size != 0){
//             size--;
//             int t = num & 1;
//             num = num >> 1;
//             System.out.print(t + " ");


//         }
        int move = 32 - size;
        num = num << move;
        num = num >> move;
        return num;
    }
}

class Solution {
    public int findComplement(int num) {
        System.out.println(Integer.toBinaryString(num));
        int size = 0; int backup = num;
        while(backup != 0){
            int t = backup & 1;
            backup = backup >> 1;
            size++;
        }
        System.out.println(size);
        
        num = ~num;
          System.out.println(Integer.toBinaryString(num));      
        int res = 0;
        List<Integer> l = new ArrayList<>();
        while(size != 0){
            size--;
            int t = num & 1;
            num = num >> 1;
            l.add(t);


        }
        res = 0;

        for(int i = l.size() - 1; i >= 0; i--){
            res = res << 1;
            res = res | l.get(i);
        }
        
        System.out.println(l);
        return res;
    }
}

//https://leetcode.com/problems/number-complement/
