package datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56MergeInterval {
    /**
     * 合并区间
     * Version 1.0 2021-07-21 by XCJ
     * Time: O(nlogn), Space: O(logn)
     * @param intervals 待合并数组序列
     * @return 合并后的数组序列
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 将区间数组按区间下界升序排列（重写Comparator[] 接口的 compare() 方法）
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> arrayMerged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i++) {
            int low = intervals[i][0], high = intervals[i][1];
            // 如果有重叠，找到满足条件的最大起点（减少判断次数）
            while (i < intervals.length - 1 && intervals[i + 1][0] <= high) {
                i++;
                high = Math.max(high, intervals[i][1]);
            }
            // 合并区间加入结果数组
            arrayMerged.add(new int[] {low, high});
        }
        return arrayMerged.toArray(new int[arrayMerged.size()][]);
    }
}
