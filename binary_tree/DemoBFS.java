package binary_tree;

import java.util.*;


public class DemoBFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\s+");
        TreeNode root = buildTree(input);
        List<List<Integer>> res = bfs(root, new ArrayList<>());
        if (res.isEmpty()) {
            System.out.println();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> list : res) {
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i));
                if (i != list.size() - 1) stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
        scanner.close();
    }


    public static List<List<Integer>> bfs(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cur_res = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                cur_res.add(node.val);
            }
            res.add(cur_res);
        }

        return res;
    }

    // 构造树
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
            // 在为外面
            i++;

            if (i < input.length && !input[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(input[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

}
