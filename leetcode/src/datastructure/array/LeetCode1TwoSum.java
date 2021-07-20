package datastructure.array;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1TwoSum {

    public int[] twoSum_Violent(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 两数之和_HashTable
     * Version 2.0 2021-07-20 by XCJ
     * @param nums int[] 数组，存储全部元素
     * @param target int 两个数的目标之和
     * @return 两个数在数组中的下标
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        // 最外层循环，对数组 nums[] 进行遍历
        for (int i = 0; i < nums.length; ++i) {
            // 查找 hashTable 是否存在键 target - nums[i])
            if (hashTable.containsKey(target - nums[i])) {
                return new int[] { hashTable.get(target - nums[i]), i };
            }
            // 如果不存在，则将 nums[i] / i 作为 键/值 对加入HashTable
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }
}
