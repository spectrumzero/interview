package simulation;

import java.util.HashMap;
import java.util.Map;

public class DemoSubArraySum {
    public static void main(String[] args) {

    }

    // 和为 k 的子数组，遍历过程中，前缀和相减
    // Input: nums = [1,1,1], k = 2
    // Output: 2
    public static int solution(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 开头，没有任何元素的时候，前缀和为 0。边界条件，不然会漏掉元素
        prefixSumCount.put(0, 1);

        for (int num: nums) {
            // 计算当前的前缀和
            sum = sum + num;
            // 子数组和 k = 后面的前缀和 sum - 前面的前缀和 preSum
            // preSum = sum - k
            // 在历史中，找到有没有前缀和为 sum - k。有，则代表有子数组的和为 k。
            if (prefixSumCount.containsKey(sum - k)) {
                // 出现了几次，就代表有多少个不同的子数组
                res += prefixSumCount.get(sum - k);
            }
            // 更新前缀和-频次 map，确保后续统计正确
            // 只能最后更新，因为子数组必须是要有元素的
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
