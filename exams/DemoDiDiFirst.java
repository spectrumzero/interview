package exams;
import java.util.Arrays;
import java.util.Scanner;

public class DemoDiDiFirst {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt(), a = scanner.nextInt(), b = scanner.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = solution(nums, a, b);
        System.out.println(res);

    }

    public static int solution(int[] nums, int a, int b) {
        Arrays.sort(nums);
        int highest = nums[nums.length - 1];
        int low = 0, high = (highest + b - 1) / b;
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(nums, a, b, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean check(int[] nums, int a, int b, int k) {
        int needed = 0;
        for (int num: nums) {
            int rem = num - k*b;
            if (rem > 0) {
                int addition = (rem + (a - b) - 1) / (a - b);
                needed += addition;
            }
            if (needed > k) {
                return false;
            }
        }
        return true;



    }
}
