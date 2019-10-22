class Solution {
    public String[] lTen  = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    public String[] lTwen = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                            "Eighteen", "Nineteen"};
    public String[] lHun = {"" ,"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if(num == 0)return "Zero";
        return conv(num);
    }
    public String conv(int num){
        String res = "";
        if(num < 10) res = lTen[num];
        else if(num < 20) res = lTwen[num - 10];
        else if(num < 100) res = lHun[num/10] + " " + lTen[num%10];
        //recur
        else if(num < 1000) res = conv(num/100) + " Hundred " + conv(num%100);
        else if(num < 1000000) res =  conv(num/1000) + " Thousand " + conv(num%1000);
        else if(num < 1000000000) res = conv(num/1000000) + " Million " + conv(num%1000000);
        else res = conv(num/1000000000) + " Billion " + conv(num%1000000000);
        return res.trim();
        
    }
}

//https://leetcode.com/problems/integer-to-english-words/
//https://leetcode.com/problems/integer-to-english-words/discuss/70627/Short-clean-Java-solution
