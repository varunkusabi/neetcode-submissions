class Solution {
    private int ans;

    // recursively extend subarray
    private void extend(int index, int[] nums, int currentProduct) {
        if (index == nums.length) {
            return;
        }

        currentProduct *= nums[index];
        ans = Math.max(ans, currentProduct);

        extend(index + 1, nums, currentProduct);
    }

    public int maxProduct(int[] nums) {
        ans = nums[0];

        // try every starting point
        for (int start = 0; start < nums.length; start++) {
            extend(start, nums, 1);
        }

        return ans;
    }
}
