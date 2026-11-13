package linkedlist;

import java.util.Scanner;

public class DemoTwoNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int l1_len = Integer.parseInt(scanner.nextLine().trim());
        String[] l1_input = scanner.nextLine().trim().split("\\s+");
        ListNode l1 = new ListNode(Integer.parseInt(l1_input[0]));
        ListNode cur = l1;
        for (int i = 1; i < l1_len; i++) {
            cur.next = new ListNode(Integer.parseInt(l1_input[i]));
            cur = cur.next;
        }
        int l2_len = Integer.parseInt(scanner.nextLine().trim());
        String[] l2_input = scanner.nextLine().trim().split("\\s+");
        ListNode l2 = new ListNode(Integer.parseInt(l2_input[0]));
        cur = l2;
        for (int i = 1; i < l2_len; i++) {
            cur.next = new ListNode(Integer.parseInt(l2_input[i]));
            cur = cur.next;
        }
        ListNode res = twoSum(l1, l2);
        StringBuilder stringBuilder = new StringBuilder();
        while (res != null) {
            stringBuilder.append(res.val);
            if (res.next != null) stringBuilder.append(" ");
            res = res.next;
        }
        System.out.print(stringBuilder);
        scanner.close();
    }

    // 两数相加
    public static ListNode twoSum(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        // 或
        while (l1 != null || l2 != null || carry != 0) {
            int op1 = l1 == null ? 0 : l1.val;
            int op2 = l2 == null ? 0 : l2.val;
            // 不仅仅要计算进位，还要加上进位
            int sum = op1 + op2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            cur.next = new ListNode(digit);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

}