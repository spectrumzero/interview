package search;

import java.util.Scanner;

public class DemoSearchMatrixII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        int target = scanner.nextInt();
        System.out.println(find(nums, target));
        scanner.close();
    }

    // 搜索二维矩阵 II
    public static boolean find(int[][] nums, int target) {
        int row = 0, col = nums[0].length - 1;
        // 这里
        while (row <= nums.length - 1 && col >=0) {
            int num = nums[row][col];
            if (num == target) {
                return true;
            } else if (num > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
