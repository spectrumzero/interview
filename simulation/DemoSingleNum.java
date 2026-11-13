package simulation;

import java.util.Scanner;

public class DemoSingleNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = solution(nums);
        System.out.println(res);
    }

    // 只出现一次的数字
    // ^ 为异或。相同设置为 0，不同的位就设置为 1。总结就是任何数字与 0 异或就是它自身，相同的数字之间异或为 0。异或满足交换率。
    public static int solution(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res = res ^ num;
        }
        return res;

    }
}
