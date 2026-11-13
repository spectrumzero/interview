package dp;

import java.util.Arrays;
import java.util.Scanner;

public class DemoLongestIncrease {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().trim().split("\\s+");
        int[] nums = new int[inputs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }
        int res = length(nums);
        System.out.println(res);
        scanner.close();
    }

    // 最长递增子序列
    // 贪心，二分法
    // nlogn
    public static int lengthGreedy(int[] nums) {
        int[] tmp = new int[nums.length];
        int len = 1;
        tmp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int left = 0, right = len - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                // 找第一个比 num 大的元素
                if (tmp[mid] >= num) { // 等于，也要确保这个循环中的更新是正确的。等于的效果最多是替换，不会影响到本次的长度，所以不应该更新 left
                    right = mid - 1;
                } else if (tmp[mid] < num){
                    left = mid + 1;
                }
            }
            tmp[left] = num;
            if (left >= len) {
                len++;
            }
        }
        return len;
    }


    // n 方（序列，可以不连续）
    public static int length(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
