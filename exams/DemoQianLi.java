package exams;

import java.util.Scanner;

public class DemoQianLi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = solution(nums, m);
        System.out.println(res);
    }

    public static int solution(int[] nums, int m) {
        int left = 1;
        int right = nums[nums.length - 1] - nums[0];
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(nums, m, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static boolean check(int[] nums, int m, int minDistance) {
        int lastLocation = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - lastLocation >= minDistance) {
                count++;
                lastLocation = nums[i];
            }
            if (count >= m) {
                return true;
            }
        }
        return false;
    }
}
