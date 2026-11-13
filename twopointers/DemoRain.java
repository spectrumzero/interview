package twopointers;

import java.util.Scanner;

public class DemoRain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(trap(nums));
        scanner.close();
    }

    public static int trap(int[] nums) {
        int res = 0;
        int left = 0, right = nums.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(nums[left], leftMax);
            rightMax = Math.max(nums[right], rightMax);
            if (leftMax < rightMax) {
                // 只确定一边的水位
                res += leftMax - nums[left];
                left++;
            } else {
                res += rightMax - nums[right];
                right--;
            }
        }
        return res;
    }
}
