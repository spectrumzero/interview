package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DemoPermutation {
    public static List<List<Integer>> res = new ArrayList<>();
    public static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\s+");
        int len = input.length;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        res = solution(nums);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            List<Integer> level = res.get(i);
            for (int j = 0; j < level.size(); j++) {
                stringBuilder.append(level.get(j));
                if (j != level.size() - 1) stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
        scanner.close();
    }

    public static List<List<Integer>> solution(int[] nums) {
        boolean[] used = new boolean[nums.length];
        dfs(nums, used);
        return res;
    }

    public static void dfs(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, used);
            used[i] = false;
            path.removeLast();
        }
    }
}
