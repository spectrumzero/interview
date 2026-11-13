package hsqh;

import java.util.HashMap;
import java.util.HashSet;

public class DemoLongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    // 数组中的最长连续子序列-128
    public static int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        int res = 0;
        // 注意这里建议去重，不然可能超时
        // 剪枝
        for (int num : set) {
            // 不是序列中的第一个数
            if (set.contains(num - 1)) {
                continue;
            }
            // 是序列中的第一个数
            int tmp = 1;
            while (set.contains(num + 1)) {
                tmp++;
                num++;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
