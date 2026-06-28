package linkedlist;

import java.util.Scanner;

public class DemoTwoTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        if (size == 0) {
            System.out.println();
            return;
        }
        String[] parts = scanner.nextLine().trim().split("\\s+");
        ListNode head = new ListNode(Integer.parseInt(parts[0]));
        ListNode cur = head;
        for (int i = 1; i < size; i++) {
            cur.next = new ListNode(Integer.parseInt(parts[i]));
            cur = cur.next;
        }
        ListNode res = exchangeTwoTwo(head);
        StringBuilder stringBuilder = new StringBuilder();
        while (res != null) {
            stringBuilder.append(res.val);
            if (res.next != null) stringBuilder.append(" ");
            res = res.next;
        }
        System.out.println(stringBuilder);

        scanner.close();
    }

    public static ListNode exchangeTwoTwo(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tmp = dummy;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            ListNode after = node2.next;
            node2.next = node1;
            node1.next = after;
            // 前面的也要接上
            tmp.next = node2;
            // 移动
            tmp = node1;
        }
        return dummy.next;

    }
}
