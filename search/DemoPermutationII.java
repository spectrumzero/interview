package search;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoPermutationII {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        // 需要排序，因为后面要判断紧邻元素来去重，与全排列一不一样，二是有重复元素的
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), used);
        return res;
    }

    // 一般来说，全排列的时间复杂度在 n!，而组合问题的时间复杂度，是 2 的 n 次方。它们的递归深度都是一致的，是 n。一样的深度，但树的规模的计算方式有点不同。
    public static void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 因为有重复元素，所以，进行了排序后去重复，false 表示不处于 i - 1 的递归过程中（已经递归完），允许跳过
            // 不加这个 false 条件，会导致有重复元素，[1,1,2]，结果就必然为 [] 的错误情况，因为错误地影响到树枝了
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, res, path, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}