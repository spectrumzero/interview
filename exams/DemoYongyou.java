package exams;

import java.util.Scanner;

public class DemoYongyou {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        int capacity = scanner.nextInt();
        int res = solution(nums, capacity);
        System.out.println(res);
    }

    public static int solution(int[] weights, int capacity) {
        int low = 1, high = weights.length;
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(weights, capacity, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean check(int[] weights, int capacity, int days) {
        int needed = 1;
        int sum = 0;
        for (int weight: weights) {
            sum += weight;
            if (sum > capacity) {
                needed++;
                sum = weight;
            }
            if (needed > days) {
                return false;
            }
        }
        return true;
    }
}
