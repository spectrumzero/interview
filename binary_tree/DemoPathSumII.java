package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class DemoPathSumII {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> res = new ArrayList<>();
    public static List<Integer> path = new ArrayList<>();

    public List<List<Integer>> solution(TreeNode root, int targetNum) {
        dfs(root, targetNum);
        return res;
    }

    public static void dfs(TreeNode root, int targetNum) {
        if (root == null) {
            return;
        }
        // 选择和收敛
        path.add(root.val);
        targetNum = targetNum - root.val;
        // 副作用，收集结果，根节点上
        if (root.left == null && root.right == null && targetNum == 0) {
            res.add(new ArrayList<>(path));
        }
        // 继续往下
        dfs(root.left, targetNum);
        dfs(root.right, targetNum);
        // 回溯
        path.remove(path.size() - 1);
    }
}
