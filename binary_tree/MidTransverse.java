package binary_tree;
import java.util.*;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val) {
        this.val = val;
    }
}

public class MidTransverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 丢弃模式
        String[] input = scanner.nextLine().trim().split("\\s+");
        TreeNode node = buildTree(input);
        List<Integer> res = midTransverse(node);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < res.size(); i++) {
            stringBuilder.append(res.get(i));
            if (i != res.size() - 1) stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);
        scanner.close();
    }

    public static List<Integer> midTransverse(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        dfs(node, res);
        return res;
    }

    public static void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }

    public static TreeNode buildTree(String[] input) {
        // 丢弃模式
        if (input.length == 0 || input[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < input.length) {
            TreeNode cur = queue.poll();

            if (i < input.length) {
                String leftVal = input[i];
                if (!leftVal.equals("null")) {
                    cur.left = new TreeNode(Integer.parseInt(leftVal));
                    queue.offer(cur.left);
                }
                i++;
            }

            if (i < input.length) {
                String rightVal = input[i];
                if (!rightVal.equals("null")) {
                    cur.right = new TreeNode(Integer.parseInt(rightVal));
                    queue.offer(cur.right);
                }
                i++;
            }
        }
        return root;

    }
}
