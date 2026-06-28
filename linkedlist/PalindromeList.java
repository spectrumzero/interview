package linkedlist;

import java.util.Scanner;

// 回文链表
public class PalindromeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        ListNode head = new ListNode(scanner.nextInt());
        ListNode cur = head;
        for (int i = 1; i < size; i++) {
            cur.next = new ListNode(scanner.nextInt());
            cur = cur.next;
        }
        System.out.println(isPalindrome(head) ? "true" : "false");
        scanner.close();
    }

    public static boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 简单比对
        ListNode tmp_list = reverse(slow.next);
        while (tmp_list != null) {
            if (tmp_list.val != head.val) {
                return false;
            }
            tmp_list = tmp_list.next;
            head = head.next;
        }
        return true;
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
