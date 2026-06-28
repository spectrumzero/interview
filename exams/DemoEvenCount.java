package exams;

import java.util.Scanner;

public class DemoEvenCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = evenCount(nums, n, l, r);
        System.out.println(res);
        scanner.close();
    }

    public static int evenCount(int[] nums, int n, int l, int r) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0 && nums[i] >= l && nums[i] <= r) {
                res++;
            }
        }
        return res;
    }
}
