class Solution {
    public String getPermutation(int n, int k) {
   LinkedList<Integer> notUsed = new LinkedList<Integer>();

	int weight = 1;

	for (int i = 1; i <= n; i++) {
		notUsed.add(i);
		if (i == n)
			break;
		weight = weight * i;
	}

        
	String res = "";
	k = k - 1;
        System.out.println(notUsed);
        System.out.println(weight);
        System.out.println(k);
        while (true) {
		res = res + notUsed.remove(k / weight);
		k = k % weight;
		if (notUsed.isEmpty())
			break;
		weight = weight / notUsed.size();
	}

	return res;
        
    }
}

//https://leetcode.com/problems/permutation-sequence/discuss/22665/Clean-Java-Solution
