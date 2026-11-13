package simulation;

public class DemoRotateImage {
    public static void main(String[] args) {

    }

    // 旋转图像，图像为正方形。顺时针旋转 90 度
    public static void solution(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            // j 必须从 i 开始，不然又会转回去了。对角线。
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            // j 要到中线为止，不然也会交换回去
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

}
