package linkedlist;

import java.util.Scanner;

public class DemoDeleteN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] parts = scanner.nextLine().trim().split("\\s+");
        ListNode head = new ListNode(Integer.parseInt(parts[0]));
        ListNode cur = head;
        for (int i = 1; i < length; i++) {
            cur.next = new ListNode(Integer.parseInt(parts[i]));
            cur = cur.next;
        }
        int n = scanner.nextInt();
        ListNode res = deleteN(head, n);
        StringBuilder sb = new StringBuilder();
        while ( res != null) {
            sb.append(res.val);
            if (res.next != null) sb.append(" ");
            res = res.next;
        }
        System.out.println(sb);

        scanner.close();
    }

    public static ListNode deleteN(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;


    }
}
