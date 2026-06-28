package binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// 副作用
public class DemoMaxPathSUm {
    // 这里，不然 res = 0 会影响后面的判断，特殊用例，比如全负数会出错
    public static int res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\s+");
        TreeNode root = buildTree(input);
        System.out.println(getMaxPathNum(root));
        scanner.close();
    }

    public static int getMaxPathNum(TreeNode root) {
        maxIncrease(root);
        return res;
    }

    // 获取最差的增长
    public static int maxIncrease(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftIncrease = Math.max(0, maxIncrease(root.left));
        int rightIncrease = Math.max(0, maxIncrease(root.right));
        res = Math.max(res, leftIncrease + rightIncrease + root.val);
        return Math.max(leftIncrease, rightIncrease) + root.val;
    }

    public static TreeNode buildTree(String[] input) {
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < input.length) {
            TreeNode node = queue.poll();
            if (!input[i].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(input[i]));
                node.left = leftNode;
                queue.offer(leftNode);
            }
            i++;
            if (i < input.length) {
                if (!input[i].equals("null")) {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(input[i]));
                    node.right = rightNode;
                    queue.offer(rightNode);
                }
                i++;
            }
        }
        return root;
    }
}
