import java.io.*;
import java.util.*;

class Solution {

  static class Word{
    public String w; public  int count; public int firstOccur;
    public Word(String w, int count, int firstOccur){
      this.w = w; this.count = count; this.firstOccur =  firstOccur;
    }
  }
  
  static Comparator<Word> comp = new Comparator<Word>(){
    
    public int compare(Word a, Word b){
      int n = b.count - a.count;
      if( n != 0){return n;}
      return a.firstOccur - b.firstOccur;
    }
  };
  
  static String[][] wordCountEngine(String document) {
    // your code goes here
    String[][] res;
    
    String[] doc = document.split(" ");
     List<String> l = new ArrayList<String>();
    for(int i = 0; i < doc.length; i++){
      if(doc[i].length() > 0){ l.add(punc(doc[i]));}
    }  

    
    Map<String,Word> map = new HashMap<String,Word>();
    for(int i = 0; i < l.size(); i++){
      String ls = l.get(i).toLowerCase();
      if(map.containsKey(ls)){   
        Word t = map.get(ls); 
        t.count = t.count + 1;
        map.put(ls, t); 
      
      }
      else{
        Word n = new Word(ls, 1, i);
        map.put(ls, n);
      }
    }

    
    PriorityQueue<Word> pq = new PriorityQueue<Word>(comp);
    
    for(Map.Entry<String, Word> entry : map.entrySet()){
      Word val = entry.getValue();
      pq.add(val);
    }
    
    res = new String[pq.size()][2];
    int i  = 0;
    while(!pq.isEmpty()){
      Word u = pq.poll();
      System.out.println(u.w);
      res[i][0] = u.w;
      res[i][1] = Integer.toString(u.count);
      i++;
      
    }
    
    return res;
  }
  
  static String punc ( String w){
    StringBuilder sb = new StringBuilder();
    char[] word = w.toCharArray();
    for(Character c : word){
      if(Character.isLetter(c)){
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String test = "pictu!re.";
    String document =  
"Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. ";
    wordCountEngine(document);
  }

}


/*
Word Count Engine
Implement a document scanning function wordCountEngine, which receives a string document and returns a list of all unique words in it and their number of occurrences, sorted by the number of occurrences in a descending order. If two or more words have the same count, they should be sorted according to their order in the original sentence. Assume that all letters are in english alphabet. You function should be case-insensitive, so for instance, the words “Perfect” and “perfect” should be considered the same word.

The engine should strip out punctuation (even in the middle of a word) and use whitespaces to separate words.

Analyze the time and space complexities of your solution. Try to optimize for time while keeping a polynomial space complexity.

Examples:

input:  document = "Practice makes perfect. you'll only
                    get Perfect by practice. just practice!"

output: [ ["practice", "3"], ["perfect", "2"],
          ["makes", "1"], ["youll", "1"], ["only", "1"], 
          ["get", "1"], ["by", "1"], ["just", "1"] ]
Important: please convert the occurrence integers in the output list to strings (e.g. "3" instead of 3). We ask this because in compiled languages such as C#, Java, C++, C etc., it’s not straightforward to create mixed-type arrays (as it is, for instance, in scripted languages like JavaScript, Python, Ruby etc.). The expected output will simply be an array of string arrays.

Constraints:

[time limit] 5000ms
[input] string document
[output] array.array.string


*/
