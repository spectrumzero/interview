package binary_tree;

import java.util.ArrayDeque;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

public class Template {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\s+");
        TreeNode root = buildTree(input);

        scanner.close();
    }

    public static TreeNode buildTree(String[] input) {
        if (input.length == 0 || input[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < input.length) {
            TreeNode node = queue.poll();
            if (!input[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(input[i]));
                queue.offer(node.left);
            }
            // 这里。是不是 null 都添加
            i++;
            if (i < input.length) {
                if (!input[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(input[i]));
                    queue.offer(node.right);
                }
                // 一样的。是不是 null 都添加
                i++;
            }
        }
        return root;
    }

}
