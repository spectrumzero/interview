package twopointers;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DemoSlidingWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] res = sliding(nums, k);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            stringBuilder.append(res[i]);
            if (i + 1 != res.length) stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);

        scanner.close();
    }

    public static int[] sliding(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // 索引，递减，队头最大的
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            // 索引。isEmpty 不是一次的判断，而是要伴随 poll 持续监控的
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            // 索引
            dq.offerLast(i);
        }
        // 返回也是，不是存索引
        res[0] = nums[dq.peek()];
        // [i, i + k -1]
        for (int i = 1; i + k - 1 <= n - 1; i++) {
            // 只要不是 i - 1，就表示我们已经把 i - 1 poll 出去了，即滑动成功；是，则要主动 poll 一次，确保滑动成功
            if (dq.peek() == i - 1) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[i + k - 1] >= nums[dq.peekLast()]) { // 所以这里光写 > 也可以，前面的最终是会先被剔除掉的
                dq.pollLast();
            }
            dq.offerLast(i + k - 1);
            res[i] = nums[dq.peek()];
        }
        return res;
    }
}
