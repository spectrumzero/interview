package search;

import java.util.Scanner;

public class DemoIslandsNum {
    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        scanner.nextLine();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            for (int j = 0; j < line.length(); j++) {
                // 这里，输入的处理，字符转数字
                grid[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(IslandsNum(grid));
        scanner.close();
    }

    public static int IslandsNum(int[][] nums) {
        int n = nums.length, m = nums[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 1) {
                    dfs(nums, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void dfs(int[][] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length || nums[i][j] == 0) {
            return;
        }
        nums[i][j] = 0;
        dfs(nums, i - 1, j);
        dfs(nums, i + 1, j);
        dfs(nums, i, j - 1);
        dfs(nums, i, j + 1);
    }
}
