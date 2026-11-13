package binary_tree;

import java.util.*;

public class DemoBFSZigZag {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.next());
        String[] input = new String[len];
        for (int i = 0; i < len; i++) {
            input[i] = scanner.next();
        }
        TreeNode root = buildTree(input);
        List<List<Integer>> res = zigzag(root, new ArrayList<>());
        int k = res.size();
        System.out.println(k);
        StringBuilder stringBuilder = new StringBuilder();
        for (List<Integer> ele: res) {
            for (int i = 0; i < ele.size(); i++) {
                stringBuilder.append(ele.get(i));
                if ( i != ele.size() - 1) stringBuilder.append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
        scanner.close();
    }


    public static List<List<Integer>> zigzag(TreeNode root, List<List<Integer>> res) {
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> collect = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                // 只影响对 collect 的添加顺序
                if (flag) {
                    collect.add(node.val);
                } else {
                    collect.addFirst(node.val);
                }
            }
            flag = !flag;
            res.add(collect);
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
