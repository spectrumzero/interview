package linkedlist;

import java.util.List;
import java.util.Scanner;

public class DemoSortLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split("\\s+");
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int i = 0; i < input.length; i++) {
            cur.next = new ListNode(Integer.parseInt(input[i]));
            cur = cur.next;
        }
        ListNode res = sort(dummy.next);
        StringBuilder stringBuilder = new StringBuilder();
        while (res != null) {
            stringBuilder.append(res.val);
            if (res.next != null) stringBuilder.append(" ");
            res = res.next;
        }
        System.out.print(stringBuilder);
        scanner.close();
    }

    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode sub_l1 = sort(mid.next);
        // aa
        mid.next = null;
        ListNode sub_l2 = sort(head);
        ListNode sorted = merge(sub_l1, sub_l2);
        return sorted;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
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
        // 别忘了
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }


    public static ListNode findMid(ListNode head) {
        // 其实不用 dummy 也可以
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

}
