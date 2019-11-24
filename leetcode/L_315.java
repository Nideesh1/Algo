class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0)return res;
        TreeNode root = new TreeNode(nums[nums.length -1]);
        res.add(0);
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--){
            int cnt = aug(root, nums[i]);
            res.add(cnt);
        }
        Collections.reverse(res);
        return res;
    }
    
    public int aug(TreeNode root, int val){
        int tc = 0;
        while(true){
            if(val <= root.val){
                root.count++;
                if(root.left == null){
                    root.left = new TreeNode(val); break;
                }else{
                    root = root.left;
                }
            }else{
                tc += root.count;
                if(root.right == null){
                    root.right = new TreeNode(val); break;
                }else{
                    root = root.right;
                }
            }
        }
        return tc;
    }
    
class TreeNode {
    TreeNode left; 
    TreeNode right;
    int val;
    int count = 1;
    public TreeNode(int val) {
        this.val = val;
    }
}
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] res = new int[nums.length];
        int[] index = new int[res.length];
        for (int i = 0; i < res.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, index, 0, nums.length-1, res);
        List<Integer> list = new LinkedList<>();
        for (int i : res) {
            list.add(i);
        }
        return list;
    }
    
    private void mergeSort(int[] nums, int[] index, int l, int r, int[] res) {
        if (l >= r) {
            return;
        }
        int mid = (l+r)/2;
        mergeSort(nums, index, l, mid, res);
        mergeSort(nums, index, mid+1, r, res);
        merge(nums, index, l, mid, mid+1, r, res);
    }
    
    private void merge(int[] nums, int[] index, int l1, int r1, int l2, int r2, int[] res) {
        int start = l1;
        int[] tmp = new int[r2-l1+1];
        int count = 0;
        int p = 0;
        while (l1 <= r1 || l2 <= r2) {
            if (l1 > r1) {
                tmp[p++] = index[l2++];
            } else if (l2 > r2) {
                res[index[l1]] += count;
                tmp[p++] = index[l1++];
            } else if (nums[index[l1]] > nums[index[l2]]) {
                tmp[p++] = index[l2++];
                count++;
            } else {
                res[index[l1]] += count;
                tmp[p++] = index[l1++];
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            index[start+i] = tmp[i];
        }
    }
}

//
