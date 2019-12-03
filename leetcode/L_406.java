class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> co = new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        };
        Arrays.sort(people, co);
        List<int[]> list =  new ArrayList<>();
        for(int[] cur : people){
            list.add(cur[1], cur);
        }
        
        return list.toArray(new int[people.length][]);
    }
}

//https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC%2B%2BJava-Solution
