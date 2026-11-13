package binary_tree;

public class DemoPathSum {
    public static void main(String[] args) {

    }

    public static boolean solution(TreeNode root, int targetNum) {
        if (root == null) {
            return false;
        }
        targetNum -= root.val;
        // 判断结果
        if (root.left == null && root.right == null && targetNum == 0) {
            return true;
        }
        // 任意到达根节点的子树返回 true，结果就是 true
        return solution(root.left, targetNum) || solution(root.right, targetNum);
    }

}
