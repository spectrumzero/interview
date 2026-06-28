package search;

import java.util.Scanner;

public class DemoElementFirstAndLast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        if (len == 0) {
            System.out.println("-1 -1");
            return;
        }
        int[] nums = new int[len];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int[] res = find(nums, target);
        System.out.println(res[0] + " " + res[1]);
        scanner.close();
    }

    public static int[] find(int[] nums, int target) {
        int[] res = new int[2];
        int left = binarySearchHelper(nums, target, true);
        int right = binarySearchHelper(nums, target, false);
        res[0] = left;
        res[1] = right;
        return res;
    }

    public static int binarySearchHelper(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                ans = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
