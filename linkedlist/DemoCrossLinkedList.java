package linkedlist;

import java.util.List;
import java.util.Scanner;

public class DemoCrossLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l1_len = scanner.nextInt();
        int skipA = scanner.nextInt();
        ListNode l1_head = new ListNode(scanner.nextInt());
        ListNode cur = l1_head;
        ListNode interSection = null;

        if (skipA == 0) {
            interSection = l1_head;
        }

        for (int i = 1; i < l1_len; i++) {
            cur.next = new ListNode(scanner.nextInt());
            cur = cur.next;
            if (skipA == i) {
                interSection = cur;
            }
        }
        // 都不满足，全部跳过，interSection 就是 null

        // 构建节点 B。
        int l2_len = scanner.nextInt();
        int skipB = scanner.nextInt();
        ListNode dummy_l2 = new ListNode(-1);
        cur = dummy_l2;
        for (int i = 0; i < l2_len; i++) {
            if (skipB == i) {
                cur.next = interSection;
                // (可选：消耗剩下的数字，for(int j = i; j < l2_len; j++)，但也没必要了)
                break;
            }
            cur.next = new ListNode(scanner.nextInt());
            cur = cur.next;
        }

        ListNode l2_head = dummy_l2.next;
        int res = getCross(l1_head, l2_head);
        System.out.println(res);
        scanner.close();
    }

    public static int getCross(ListNode l1, ListNode l2) {
        ListNode curA = l1, curB = l2;
        while (curA != curB) {
            // curA 和 curB 要可以为 null。可别写错，否则，永远不会为 null，就无法从两条平行线中 break 出来，直接超时
            // 之后是切换到没有变化的 l2 和 l1 上。
            curA = curA == null ? l2 : curA.next;
            curB = curB == null ? l1 : curB.next;
        }
        return curA == null ? 0 : curA.val;

    }


}
