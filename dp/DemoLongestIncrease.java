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
    // 这解法神了
    public static int lengthGreedy(int[] nums) {
        // 注意，tmp 存储的不是最终的最长序列的集合，但是它的长度是解。
        int[] tmp = new int[nums.length];
        int len = 1;
        tmp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int target = nums[i];
            int left = 0, right = len - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                // 找一个比 num 大的元素，且这个元素应该尽可能地小，即靠左，用 num 来替换它
                // 查找目标就是找等于 num 的元素，这样去写代码
                if (tmp[mid] >= target) { // 等于，也要确保这个循环中的更新是正确的。等于的效果最多是替换，不会影响到本次的长度，所以不应该更新 left
                    right = mid - 1;
                } else if (tmp[mid] < target){
                    left = mid + 1;
                }
            }
            // 替换。替换是未来的贪心
            tmp[left] = target;
            if (left >= len) {
                // 这种替换是 append，更新长度。结果的来源。
                len++;
            }
        }
        return len;
    }


    // n 方（序列，可以不连续）
    public static int length(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        // 初始化要正确
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
