class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i-1)) {
                stk.push(1);
            } else {
                int incremented = stk.pop() + 1;
                if (incremented == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stk.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}

/*
It was a 45 min interview. First he started with my introduction and some prior experience of work for about 10 minutes and asked me why i wanted to join bloomberg. Then told me to open the hackerrank link where he gave me :

Given a , reduce the string by removing 3 or more consecutive identical characters. You should greedily remove characters from left to right.

Example 1:

Input: "aaabbbc"
Output: "c"
Explanation:
1. Remove 3 'a': "aaabbbc" => "bbbc"
2. Remove 3 'b': "bbbc" => "c"

Example 2:

Input: "aabbbacd"
Output: "cd"
Explanation:
1. Remove 3 'b': "aabbbacd" => "aaacd"
2. Remove 3 'a': "aaacd" => "cd"

Example 3:

Input: "aabbccddeeedcba"
Output: ""
Explanation:
1. Remove 3 'e': "aabbccddeeedcba" => "aabbccdddcba"
2. Remove 3 'd': "aabbccdddcba" => "aabbcccba"
3. Remove 3 'c': "aabbcccba" => "aabbba"
4. Remove 3 'b': "aabbba" => "aaa"
5. Remove 3 'a': "aaa" => ""

Example 4:

Input: "aaabbbacd"
Output: "acd"
Explanation:
1. Remove 3 'a': "aaabbbacd" => "bbbacd"
2. Remove 3 'b': "bbbacd" => "acd"

I solved it with recursion and also discussed the stack based approach.

Follow-up:
What if you need to find the shortest string after removal?

Example:

Input: "aaabbbacd"
Output: "cd"
Explanation:
1. Remove 3 'b': "aaabbbacd" => "aaaacd"
2. Remove 4 'a': "aaaacd" => "cd"


class Solution {
    public String removeDuplicates(String s, int k) {
        for (int i= 0; i < s.length(); i++) {
            if ((i + k - 1)  < s.length() && allSame(s, i, k) ) {
                int j = i;
                i += k - 1;
                
                char repeated = s.charAt(i);
                while (i < s.length() && s.charAt(i) == repeated) {
                    i++;
                }
                
                String left = s.substring(0, j);
                String right = s.substring(i);
                left += right;
                
                return removeDuplicates(left, k);
            }
        }
        
        return s;
    }

    boolean allSame(String s, int i, int k) {
        int l = i, r = i + k - 1;
        while (l <= r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

*/

#include<iostream>
#include<unordered_map>
using namespace std;

string greedyCandyCrush(string s){
    for(int i=0;i<s.length();++i){

        if(i+2<s.length() && i+1<s.length() && s[i]==s[i+1] && s[i]==s[i+2]){  // found the series of atleast 3 similar elements
            int j = i;
            i+=2;
            
            char repeated = s[i];

            while(i<s.length() && s[i]==repeated){ // For more than 3 repeats of the same character
                ++i;
            }

            string left = string(s.begin(),s.begin()+j);
            string right = string(s.begin()+i,s.end());

            left.append(right);

            return greedyCandyCrush(left);
        }
        
    }
    return s;
}

/* At every point there can be 2 solutions, either to crush it or pass it*/
string recursion(string s,int i){

    for(;i<s.length();++i){
        if(i+2<s.length() && i+1<s.length() && s[i]==s[i+1] && s[i]==s[i+2]){ // found 3 similar elements
            int j = i;
            i+=2;

            char repeated = s[i];

            while(i<s.length() && s[i]==repeated){
                ++i;
            }

            string left = string(s.begin(),s.begin()+j);
            string right = string(s.begin()+i,s.end());

            left.append(right);

            string uncrushed = recursion(s,i);
            string crushed = recursion(left,0);

            return (uncrushed.length()<crushed.length())? uncrushed : crushed;
        }
    }

    return s;
}


string recursiveBestCandyCrush(string s){
    return recursion(s,0);
}

string recursionWithMemoization(string s,int i,unordered_map<string,string>& mp){

    if(mp.find(s)!=mp.end()) return mp[s];

    for(;i<s.length();++i){
        if(i+2<s.length() && i+1<s.length() && s[i]==s[i+1] && s[i]==s[i+2]){ // found 3 similar elements
            int j = i;
            i+=2;

            char repeated = s[i];

            while(i<s.length() && s[i]==repeated){
                ++i;
            }

            string left = string(s.begin(),s.begin()+j);
            string right = string(s.begin()+i,s.end());

            left.append(right);

            string uncrushed = recursionWithMemoization(s,i,mp);
            string crushed = recursionWithMemoization(left,0,mp);

            if(uncrushed.length()<crushed.length()){
                mp[s] = uncrushed;
                return uncrushed;
            }

            else{
                mp[s] = crushed;
                return crushed;
            }

        }
    }

    return s;
}


string dynamicTopDown(string s){
    unordered_map<string,string> mp;
    return recursionWithMemoization(s,0,mp);
}

int main(){
	/* TEST CASE 1 */
	std::cout<<"-----------------------GREEDY-------------------------"<<std::endl;
	string s = "aaabbbc";
	std::cout<<s<<" : "<<greedyCandyCrush(s)<<std::endl;

	/* TEST CASE 2 */
	std::cout<<"-----------------------GREEDY-------------------------"<<std::endl;
	s = "aabbbacd";
	std::cout<<s<<" : "<<greedyCandyCrush(s)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;

	/* TEST CASE 3 */
	std::cout<<"-----------------------GREEDY-------------------------"<<std::endl;
	s = "aabbccddeeedcba";
	std::cout<<s<<" : "<<greedyCandyCrush(s)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;
    
	/* TEST CASE 4 */
	std::cout<<"-----------------------GREEDY-------------------------"<<std::endl;
	s = "aaabbbacd";
	std::cout<<s<<" : "<<greedyCandyCrush(s)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;

	/* TEST CASE 5*/
	std::cout<<"-----------------------GREEDY-------------------------"<<std::endl;
	s = "aaaaabbbbbbbbbbbbbbc";
	std::cout<<s<<" : "<<greedyCandyCrush(s)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;
    
	/* TEST CASE 6 */
	std::cout<<"-----------------------GREEDY-------------------------"<<std::endl;
	s = "aaabbbacd";
	std::cout<<s<<" : "<<greedyCandyCrush(s)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;



	/* TEST CASE 1 */
	std::cout<<"-----------------------RECURSION-------------------------"<<std::endl;
	string s1 = "aaabbbc";
	std::cout<<s1<<" : "<<recursiveBestCandyCrush(s1)<<std::endl;

	/* TEST CASE 2 */
	std::cout<<"-----------------------RECURSION-------------------------"<<std::endl;
	s1 = "aabbbacd";
	std::cout<<s1<<" : "<<recursiveBestCandyCrush(s1)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;

	/* TEST CASE 3 */
	std::cout<<"-----------------------RECURSION-------------------------"<<std::endl;
	s1 = "aabbccddeeedcba";
	std::cout<<s1<<" : "<<recursiveBestCandyCrush(s1)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;
    
	/* TEST CASE 4 */
	std::cout<<"-----------------------RECURSION-------------------------"<<std::endl;
	s1 = "aaabbbacd";
	std::cout<<s1<<" : "<<recursiveBestCandyCrush(s1)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;

	/* TEST CASE 5*/
	std::cout<<"-----------------------RECURSION-------------------------"<<std::endl;
	s1 = "aaaaabbbbbbbbbbbbbbc";
	std::cout<<s1<<" : "<<recursiveBestCandyCrush(s1)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;
    
	/* TEST CASE 6 */
	std::cout<<"-----------------------RECURSION-------------------------"<<std::endl;
	s1 = "aaabbbacd";
	std::cout<<s1<<" : "<<recursiveBestCandyCrush(s1)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;
    


	/* TEST CASE 1 */
	std::cout<<"-----------------------DYNAMICTOPDOWN-------------------------"<<std::endl;
	string s2 = "aaabbbc";
	std::cout<<s2<<" : "<<dynamicTopDown(s2)<<std::endl;

	/* TEST CASE 2 */
	std::cout<<"-----------------------DYNAMICTOPDOWN-------------------------"<<std::endl;
	s2 = "aabbbacd";
	std::cout<<s2<<" : "<<dynamicTopDown(s2)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;

	/* TEST CASE 3 */
	std::cout<<"-----------------------DYNAMICTOPDOWN-------------------------"<<std::endl;
	s2 = "aabbccddeeedcba";
	std::cout<<s2<<" : "<<dynamicTopDown(s2)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;
    
	/* TEST CASE 4 */
	std::cout<<"-----------------------DYNAMICTOPDOWN-------------------------"<<std::endl;
	s2 = "aaabbbacd";
	std::cout<<s2<<" : "<<dynamicTopDown(s2)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;

	/* TEST CASE 5*/
	std::cout<<"-----------------------DYNAMICTOPDOWN-------------------------"<<std::endl;
	s2 = "aaaaabbbbbbbbbbbbbbc";
	std::cout<<s2<<" : "<<dynamicTopDown(s2)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;
    
	/* TEST CASE 6 */
	std::cout<<"-----------------------DYNAMICTOPDOWN-------------------------"<<std::endl;
	s2 = "aaabbbacd";
	std::cout<<s2<<" : "<<dynamicTopDown(s2)<<std::endl;
	std::cout<<"------------------------------------------------------"<<std::endl;


    return 0;
}

//https://gist.github.com/atiwari3bu/6feb336753cfc65d58d8b513a8136ae3
