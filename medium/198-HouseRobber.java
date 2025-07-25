class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        switch (length) {// base case for smaller length
            case (1):
                return nums[0];
            case (2):
                return Math.max(nums[0], nums[1]);
        }
        int[] totLoot = new int[length];

        totLoot[0] = nums[0];
        totLoot[1] = Math.max(nums[0], nums[1]);// Init first two so no out of bounds exception
        for (int i = 2; i < length; i++) {
            totLoot[i] = Math.max(totLoot[i - 2] + nums[i], totLoot[i - 1]);
        }
        return totLoot[length - 1];
    }
}
