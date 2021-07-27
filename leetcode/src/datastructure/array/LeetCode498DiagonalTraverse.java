package datastructure.array;

public class LeetCode498DiagonalTraverse {

    private int k = 0;	// 返回结果res[]的下标指针

    /**
     * 方法1：两个标志位
     * Version 1.0 2021-07-27 by XCJ
     * @param matrix 待遍历数组
     * @return 对角线遍历结果
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int tR = 0;     // 右上标志位横坐标
        int tC = 0;     // 右上标志位纵坐标
        int dR = 0;     // 左下标志位横坐标
        int dC = 0;     // 左下标志位纵坐标
        int endR = matrix.length -1;
        int endC = matrix[0].length - 1;
        int[] res = new int[(endR + 1) * (endC + 1)];
        boolean fromUp = false;
        while  (tR != endR + 1) {
            traverseDiagonal(matrix, tR, tC, dR, dC, fromUp, res);   // 遍历一个对角线
            tR = tC == endC ? tR + 1 : tR; 		// 注意更新顺序
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;   // 方向取反
        }
        return res;
    }

    // 访问一条对角线的元素，并将访问结果按顺序存储在 res[] 中
    public void traverseDiagonal(int[][] m, int tR, int tC, int dR, int dC, boolean fromUp, int[] res) {
        if (fromUp) {
            // 自右上向左下访问对角线元素
            while (tR != dR + 1) {
                res[k++] = m[tR++][tC--];
            }
        }
        else {
            // 自左下向右上访问对角线元素
            while (dR != tR - 1) {
                res[k++] = m[dR--][dC++];
            }
        }
    }


    /**
     * 方法2：找规律
     * Version 1.0 2021-07-27 from LeetCode comments
     * @param matrix 待遍历数组
     * @return 对角线遍历结果
     */
    public int[] findDiagonalOrder_2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int r = 0, c = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] res = new int[row * col];
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            // r + c == 当前层数，偶数向右上遍历，奇数向左下遍历
            if ((r + c) % 2 == 0) {
                if (c == col - 1) {
                    // 下移一格准备向下遍历
                    r++;
                } else if (r == 0) {
                    // 向右移动一格准备向下遍历
                    c++;
                } else {
                    // 向右上方移动
                    r--;
                    c++;
                }
            } else {
                if (r == row - 1) {
                    // 移一格准备向上遍历
                    c++;
                } else if (c == 0) {
                    // 向下移动一格准备向上遍历
                    r++;
                } else {
                    // 向下移动
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
