package binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class DemoClosestCommonAncestor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nodes = scanner.nextLine().trim().split("\\s+");
        TreeNode root = buildTree(nodes);
        int p_val = scanner.nextInt();
        int q_val = scanner.nextInt();
        TreeNode p = findNode(root, p_val);
        TreeNode q = findNode(root, q_val);
        TreeNode res = findCCA(root, p, q);
        System.out.println(res.val);
        scanner.close();
    }

    public static TreeNode findCCA(TreeNode root, TreeNode p, TreeNode q) {
        // 思考，递归的终止条件。找不到，终止；找到了，也终止
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = findCCA(root.left, p, q);
        TreeNode right = findCCA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    // 遍历一颗二叉树，寻找二叉树上的某个节点
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }

    public static TreeNode buildTree(String[] nodes) {
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        int index = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode node = queue.poll();
            if (!nodes[index].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[index]));
                node.left = leftNode;
                queue.offer(leftNode);
            }
            index++;
            if (index < nodes.length && !nodes[index].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[index]));
                node.right = rightNode;
                queue.offer(rightNode);
            }
            index++;
        }
        return root;
    }

}