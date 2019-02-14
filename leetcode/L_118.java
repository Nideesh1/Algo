class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0){return res;}
        List<Integer> row = new ArrayList<>();
        row.add(1);
        res.add(new ArrayList<>(row));
        row.clear();
        for(int rowNum = 1; rowNum < numRows; rowNum++){
            
            List<Integer> prevRow = res.get(rowNum-1);
            row.add(1);
            for(int j = 1; j < rowNum; j++){
                row.add( prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            
            res.add(new ArrayList<>(row));
            row.clear();
        }
        
        return res;
    }
}

//https://leetcode.com/problems/pascals-triangle/description/
