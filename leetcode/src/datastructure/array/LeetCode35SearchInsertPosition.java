package datastructure.array;

public class LeetCode35SearchInsertPosition {
    /**
     * 寻找数组中心下标_遍历
     * Version 1.0 2021-07-21 by XCJ
     * Time: O(logn), Space: O(1)
     * @param nums 查找数组
     * @param target 目标值
     * @return 插入位置下标
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, res = nums.length;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left; // (right - left) / 2 + left
            if (target <= nums[mid]) {
                res = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return res;
    }
}
