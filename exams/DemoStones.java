package exams;

import java.util.Scanner;

public class DemoStones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        long res = count(nums, x, y);
        System.out.println(res);
        scanner.close();
    }

    public static long count(int[] nums, int x, int y) {
        long res = 0;
        for (int num: nums) {
            if (num > x) {
                res = res + y;
            }
        }
        return res;

    }
}
