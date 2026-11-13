package binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class DemoDiameter {
    public static int res;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\s+");
        TreeNode root = buildTree(input);
        System.out.println(diameter(root));
        scanner.close();
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

    public static int diameter(TreeNode root) {
        maxDepth(root);
        return res;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        res = Math.max(leftDepth + rightDepth, res);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
