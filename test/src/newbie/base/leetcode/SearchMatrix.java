package newbie.base.leetcode;

public class SearchMatrix {

    /**
     * 搜索二维矩阵 II
     * <p>
     * 示例:
     * 现有矩阵 matrix 如下：
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * <p>
     * 给定 target = 5，返回 true。
     * 给定 target = 20，返回 false。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(arr, 5));
    }

    /**
     * 自己的
     */
    /*public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix != null || matrix.length > 0) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length > 0) {
                    if (target > matrix[i][matrix[i].length - 1]) { // 如果大于当前行的末位元素 继续循环
                        continue;
                    } else {
                        int low = 0, high = matrix[i].length, mid = matrix[i].length / 2;
                        while (low <= high) {
                            mid = (low + high) / 2;
                            if (matrix[i][mid] == target) {
                                return true;
                            } else {
                                if (target > matrix[i][mid]) {
                                    low = mid + 1;
                                } else {
                                    high = mid - 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }*/

    /**
     * 大佬的
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (null != matrix && matrix.length > 0) {
            int m = matrix.length, n = matrix[0].length; // 预设是个正常长方形矩阵 即每行长度相等
            int row=0, cow=n-1; // 创建行、列坐标
            while (cow >= 0 && row < m) {
                if (matrix[row][cow] == target) { // 相等
                    return true;
                }
                if (target > matrix[row][cow]) { // 目标值 大于 当前行最后一个元素
                    row++; // 移动到下一行
                } else if (target < matrix[row][cow]){
                    cow--; // 移动到下一列
                }
            }
        }
        return false;
    }

}
