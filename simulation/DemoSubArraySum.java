package simulation;

import java.util.HashMap;
import java.util.Map;

public class DemoSubArraySum {
    public static void main(String[] args) {

    }

    // 和为 k 的子数组，前缀和的应用，区间问题
    public static int solution(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 前缀和是要有一个空前缀的，状态的转移要正确
        prefixSumCount.put(0, 1);

        for (int num: nums) {
            sum = sum + num;
            if (prefixSumCount.containsKey(sum - k)) {
                res += prefixSumCount.get(sum - k);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
