package search;

public class DemoSearchMatrix {
    public static void main(String[] args) {

    }

    public static boolean solution(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int left = 0, right = n*m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 对列数取模，不要搞错
            int row = mid / m;
            int col = mid % m;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
