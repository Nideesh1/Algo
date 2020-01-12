//https://leetcode.com/problems/distinct-echo-substrings/discuss/477060/Accepted-O(n2)-rolling-hash-solution

public class Solution {
    long mod = 100000000000007L;

    public int distinctEchoSubstrings(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        Set<Long> set = new HashSet<>();
        long headexp = 1L;
        for (int l = 1; 2 * l - 1 < n; l++) {
            headexp *= 26;
            headexp %= mod;
            long hash1 = initialHash(cs, 0, l - 1);
            long hash2 = initialHash(cs, l, 2 * l - 1);
            if (hash1 == hash2) {
                set.add(hash1);
            }
            // System.out.println("h1 " + hash1);
            // System.out.println("h2 " + hash2);
            // System.out.println(l);
            
            for (int i = 1; i + 2 * l - 1 < n; i++) {
                // rolling hash
                hash1 = updateHash(cs, hash1, headexp, i - 1, i + l - 1);
                hash2 = updateHash(cs, hash2, headexp, i - 1 + l, i + 2 * l - 1);
                if (hash1 == hash2) {
                    //set.add(hash1);
                }
            }
        }
        return set.size();
    }

    private long initialHash(char[] cs, int i, int j) {
        long hash = 0L;
        for (int k = i; k <= j; k++) {
            hash = hash * 26 + (tocode(cs[k]));
            hash %= mod;
        }
        return hash;
    }

    private long updateHash(char[] cs, long hash, long headexp, int index1, int index2) {
        hash = hash * 26 + (tocode(cs[index2]));
        hash = (hash - headexp * tocode(cs[index1])) % mod;
        hash = (hash + mod) % mod; // in case hash turns negative from above minus...
        return hash;
    }

    private int tocode(char c) {
        return c - 'a' + 1;
    }
}



class Solution {
    int prime = 31;
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        Set<Long> set = new HashSet<>();
        //System.out.println(n + " n is");
        char[] str = text.toCharArray();
        for(int len = 1; len*2 - 1 < n; len++){
            
            String s1 = text.substring(0, len);
            long h1 = s1.hashCode();
            
            
            String s2 = text.substring(len, len*2);
            long h2 = s2.hashCode();
            
            if(h1 == h2 && s1.equals(s2)) set.add(h1);
            
            for(int i = 1; i + 2*len - 1 <n ; i++){
                s1 = text.substring(i, i + len);
                s2 = text.substring(i + len, i + 2*len);
                h1 = s1.hashCode(); //rehash(str, h1, i - 1, i + len - 1, len);
                h2 = s2.hashCode(); //rehash(str, h2, i + len - 1, i + 2*len - 1, len);
                
                if(h1 == h2 && s1.equals(s2)){
                    set.add(h1);
                }
                
            }
            
            
        }
        
        return set.size();
    }
    
    public long hash(char[] ar, int len){
        long hash = 0;
        for(int i = 0; i <= len; i++){
            hash += ar[i] * Math.pow(prime, i);
        }
        return hash;
    }
    
    public long rehash(char[] ar, long oldHash, int oldIndex, int newIndex, int len){
        long rehash = oldHash - ar[oldIndex];
        rehash /= prime;
        rehash += ar[newIndex] * Math.pow(prime, len - 1);
        return rehash;
    }
}

//https://github.com/mission-peace/interview/blob/master/src/com/interview/string/RabinKarpSearch.java
