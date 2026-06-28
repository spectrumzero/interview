package linkedlist;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class DemoMergeK {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 主函数传入递归函数 3 个参数。注意，只有 3 个
        // 对这个区间排序
        return mergeHelper(lists, 0, lists.length - 1);

    }

    public static ListNode mergeHelper(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l) / 2;
        ListNode left = mergeHelper(lists, l, mid);
        ListNode right = mergeHelper(lists, mid + 1, r);
        return mergeTwoLists(left, right);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            System.out.println();
            return;
        }
        String firstline = scanner.nextLine().trim();
        if (firstline.isEmpty()) {
            System.out.println();
            return;
        }
        int length = Integer.parseInt(firstline);
        if (length == 0) {
            System.out.println();
            return;
        }
        ListNode[] lists = new ListNode[length];
        for (int i = 0; i < length; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                lists[i] = null;
                continue;
            }
            String[] parts = line.split("\\s+");
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            for (String part : parts) {
                if (!part.isEmpty()) {
                    cur.next = new ListNode(Integer.parseInt(part));
                    cur = cur.next;
                }
            }
            lists[i] = dummy.next;
        }
        ListNode head = mergeKLists(lists);
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) {
                sb.append(" ");
            }
            head = head.next;
        }
        System.out.println(sb);

        scanner.close();
    }

}
