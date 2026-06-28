package binary_tree;

import java.util.*;

public class DemoRightVision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.next());
        String[] input = new String[len];
        for (int i = 0; i < len; i++) {
            input[i] = scanner.next();
        }
        TreeNode root = buildTree(input);
        List<Integer> res = rightVison(root, new ArrayList<>());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            stringBuilder.append(res.get(i));
            if (i != res.size() - 1) stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);
        scanner.close();
    }


    public static List<Integer> rightVison(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
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
            // 这里
            i++;
            if (i < input.length) {
                if (!input[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(input[i]));
                    queue.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }
}
