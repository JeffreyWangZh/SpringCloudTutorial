package array.offer;

/**
 * @Author jw9j
 * @create 2021/6/8 23:27
 */
public class Offer04 {

    // 解法1 二维数组的暴力破解
    public boolean findNumberIn2DArray_1(int[][] matrix, int target) {
        // 特殊情况：matrix null
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 解法2： 利用横向纵向的关联关系
    public boolean findNumberIn2DArray_2(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
