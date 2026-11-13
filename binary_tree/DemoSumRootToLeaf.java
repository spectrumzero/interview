package binary_tree;

// 从根节点到叶子节点之和
public class DemoSumRootToLeaf {
    public static void main(String[] args) {

    }

    // 副作用
    public static int res = 0;

    public static int solution(TreeNode root) {
        // root 的 parent 为 0，不影响计算判断
        dfs(root, 0);
        return res;
    }

    public static void dfs(TreeNode node, int parentSum) {
        if (node == null) {
            return;
        }
        // 提前判断，如果是叶子节点，即可收集结果
        if (node.left == null && node.right == null) {
            res += (parentSum * 10 + node.val);
            return;
        }
        dfs(node.left, (parentSum * 10 + node.val));
        dfs(node.right, (parentSum * 10 + node.val));
    }
}
