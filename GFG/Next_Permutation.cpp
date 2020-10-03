//Getting the Next Permutation From the string
//  ex- 45621
//	ans- 46125 

#include <bits/stdc++.h>
using namespace std;
void swap(char&a,char& b)
{
	if(a==b)
	{
		return;
	}
	a^=b;
	b^=a;
	a^=b;
}
void reversestring(string& s, int l, int r) 
{ 
    while (l < r) 
        swap(s[l++], s[r--]); 
} 
int binarysearch(string s,int l,int r,int k)
{
	int index =-1;
	while(l<=r){
		int m=l+(r-l)/2;
		if(s[m]<=k)
		{
			r=m-1;
		}
		else
		{
			l=m+1;
			if (index == -1 || s[index] >= s[m]) 
                index = m; 
		}
	}
	return index;
}
bool getnextpnc(string& s)
{
	int n= s.length(); int i= n-2;

	while(i>=0 && s[i]>=s[i+1])
		i--;							
	if(i<0)	return false;
	else{
		int x= binarysearch(s,i+1,n-1,s[i]);
		swap(s[x],s[i]);
		reversestring(s, i + 1, n- 1); 
        return true; 
	}
}
int main() 
{ 
	int t;
	cin>>t;
	while(t--)
	{
		string s;
		cin>>s;
		bool res = getnextpnc(s);
		if(res)
		{
			cout<<s<<endl;
		}
		else
			cout<<"no answer"<<"\n";
	}

} 
