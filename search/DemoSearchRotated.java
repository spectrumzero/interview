package search;

import java.util.Scanner;

public class DemoSearchRotated {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        System.out.println(find(nums, target));
        scanner.close();
    }

    public static int find(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 收集结果
            if (nums[mid] == target) {
                res = mid;
                break;
            }
            // 判断 [left, mid] 是否有序，哪怕只有一个元素，也应该判断为有序。所以必须要带等号，否则之后的有序区间的逻辑会乱
            if (nums[left] <= nums[mid]) {
                // 判断在不在这个范围，而不是仅比较极值，因为右边也可能存在小于这个极值的情况
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 同理
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return res;

    }

}
