package dp;

import java.lang.classfile.attribute.SourceDebugExtensionAttribute;
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
        int len = 0;
        for (int num : nums) {
            // 一种二分搜索。二分搜索，就是用两个指针进行移动
            // 在 tmp 中二分搜索
            int left = 0, right = len;
            while (left < right) {
                int mid = (left + right) / 2;
                // 在 tmp 中寻找第一个大于或等于 num 的数
                if (tmp[mid] >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // 并用 num 替代它
            tmp[left] = num;
            // 这个时候如果发现其实 left 已经越界，说明不是代替，而是 append，因为原来的 tmp 中的所有元素都小于 num
            if (left == len) {
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
