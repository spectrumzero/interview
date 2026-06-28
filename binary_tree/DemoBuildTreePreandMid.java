package binary_tree;

import java.util.*;

public class DemoBuildTreePreandMid {
    static Map<Integer, Integer> mapping = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        int[] preOrder = new int[size];
        for (int i = 0; i < size; i++) {
            preOrder[i] = scanner.nextInt();
        }
        int[] inOrder = new int[size];
        for (int i = 0; i < size; i++) {
            inOrder[i] = scanner.nextInt();
        }
        TreeNode root = build(preOrder, inOrder);
        printTree(root);
        scanner.close();
    }

    public static void printTree(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        // ArrayDeque 不支持放入 null，LinkedList 支持。它们都实现了 Queue/Deque。
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                stringBuilder.append(node.val);
                stringBuilder.append(" ");
                // 这里
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                stringBuilder.append("null");
                stringBuilder.append(" ");
            }
        }
        String res = stringBuilder.toString().trim();
        // string 去掉多余的 null
        while (res.endsWith(" null")) {
            // 丢弃五个字符
            res = res.substring(0, res.length() - 5);
        }
        System.out.println(res);
    }


    public static TreeNode build(int[] preOrder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            mapping.put(inorder[i], i);
        }
        TreeNode root = helper(preOrder, 0, preOrder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    public static TreeNode helper(int[] preOrder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        // 终止条件和剪枝是不一样的
        if (pre_start > pre_end) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[pre_start]);
        int sliceIndex = mapping.get(root.val);
        int leftSize = sliceIndex - in_start;
        int rightSize = in_end - sliceIndex;
        root.left = helper(preOrder, pre_start + 1, pre_start + leftSize, inorder, in_start, in_start + leftSize - 1);
        root.right = helper(preOrder, pre_start + leftSize + 1, pre_end, inorder, in_start + leftSize + 1, in_end);
        return root;
    }
}
