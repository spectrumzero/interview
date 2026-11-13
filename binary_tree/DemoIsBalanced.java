package binary_tree;

public class DemoIsBalanced {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l_depth = depth(root.left);
        int r_depth = depth(root.right);
        return Math.abs(l_depth - r_depth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
