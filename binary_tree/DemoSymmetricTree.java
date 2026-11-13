package binary_tree;

// 对称二叉树。对称这里指的是仅一条中心轴对称
public class DemoSymmetricTree {
    public static void main(String[] args) {

    }

    public static boolean solution(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public static boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);

    }
}
