package linkedlist;

import java.util.Scanner;

public class DemoCircleLinkedListTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        if (size <= 1) {
            System.out.println(-1);
            return;
        }
        ListNode head = new ListNode(scanner.nextInt());
        ListNode cur = head;
        for (int i = 1; i < size; i++) {
            cur.next = new ListNode(scanner.nextInt());
            cur = cur.next;
        }
        int entry = scanner.nextInt();
        if (entry != -1) {
            ListNode tmp = head;
            for (int i = 0; i < entry; i++) {
                tmp = tmp.next;
            }
            cur.next = tmp;
        }
        ListNode res = searchEntry(head);
        System.out.println(res == null ? "null" : entry);
        scanner.close();
    }

    public static ListNode searchEntry(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
