package datastructure.array;

public class LeetCode48RotateImage {
    /**
     * 顺时针旋转矩阵90°
     * Version 1.0 2021-07-24 by XCJ
     * @param matrix 待旋转矩阵
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; i++)
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        // 对角线翻转
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
    }
}
