package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DemoThreeNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        List<List<Integer>> res = threeNum(nums, new ArrayList<>());
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> ele: res) {
            for (int i = 0; i < ele.size(); i++) {
                stringBuilder.append(ele.get(i));
                if ( i != ele.size() - 1) stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
        scanner.close();
    }

    public static List<List<Integer>> threeNum(int[] nums, List<List<Integer>> res) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int rest = -a;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int b = nums[left];
                int c = nums[right];
                if (b + c == rest) {
                    List<Integer> collect = new ArrayList<>();
                    // 添加 a, b, c
                    collect.add(a);
                    collect.add(b);
                    collect.add(c);
                    res.add(collect);
                    left++;
                    right--;
                    // while 循环基本功
                    // 循环的条件决定了它什么时候终止，想要它什么时候终止就要有什么样子的循环条件，用 && 拼接多个条件，用 || 来选择一个条件
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (b + c < rest) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
