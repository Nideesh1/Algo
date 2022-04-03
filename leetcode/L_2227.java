class Encrypter {
    Map<Character,String> map = new HashMap<>();
    Set<String> dictionary = new HashSet<>();
    Map<String,Integer> decrypt = new HashMap<>();
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        for (String d : dictionary) this.dictionary.add(d);
        //System.out.println(decrypt);
        for(String dict : dictionary) {
            String encrpted = encrypt(dict);
            decrypt.put(encrpted, decrypt.getOrDefault(encrpted, 0) + 1);
        }
    
    }
    
    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (char c : word1.toCharArray()) sb.append(map.get(c));
        return sb.toString();
    }
    
    public int decrypt(String word2) {
        return decrypt.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
