package datastructure.array;

public class LeetCode724FindPivotIndex {

    /**
     * 寻找数组中心下标
     * Version 1.0 2021-07-21 by XCJ
     * Time: O(n), Space: O(1)
     * @param nums 目标数组
     * @return int 中心下标，未找到返回 -1
     */
    public int pivotIndex(int[] nums) {
        // 求和
        int total = 0;
        for (int val : nums) {
            total += val;
        }

        // 找中点
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == (total -= nums[i])) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
