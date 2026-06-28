package linkedlist;

import java.util.Scanner;

public class DemoKReverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().trim().split("\\s+");
        ListNode head = new ListNode(Integer.parseInt(parts[0]));
        ListNode cur = head;
        for (int i = 1; i < parts.length; i++) {
            cur.next = new ListNode(Integer.parseInt(parts[i]));
            cur = cur.next;
        }
        int k = scanner.nextInt();
        ListNode res = kReverse(head, k);
        StringBuilder stringBuilder = new StringBuilder();
        while (res != null) {
            stringBuilder.append(res.val);
            if(res.next != null) stringBuilder.append(" ");
            res = res.next;
        }
        System.out.println(stringBuilder);



        scanner.close();
    }

    public static ListNode kReverse(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre_end = dummy;
        ListNode end = dummy;
        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode tmp = end.next;
            end.next = null;
            ListNode start = pre_end.next;
            pre_end.next = reverse(start);
            start.next = tmp;
            pre_end = start;
            end = start;
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


}
