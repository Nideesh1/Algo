class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    private int[] mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return new int[]{nums[start]};
        }
        int mid = (start + end) / 2;
        return merge(mergeSort(nums, start, mid), mergeSort(nums, mid + 1, end));
    }
    private int[] merge(int[] a, int[] b) {
        int m = a.length, n = b.length;
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            result[k++] = (a[i] <= b[j]) ? a[i++] : b[j++];
        }

        while (i < m) result[k++] = a[i++];
        while (j < n) result[k++] = b[j++];

        return result;
    }
}
