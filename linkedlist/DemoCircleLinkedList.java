package linkedlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DemoCircleLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        if (size == 0) {
            System.out.println("false");
            return;
        }
        Map<Integer, ListNode> addr_map = new HashMap<>();
        ListNode head = null;
        for (int i = 0; i < size; i++) {
            int addr = scanner.nextInt();
            int val = scanner.nextInt();
            int next_addr = scanner.nextInt();
            // 如果在 map 中已经存在，说明当前节点已经与前一个点相连，更新就好
            if (addr_map.containsKey(addr)) {
                ListNode node = addr_map.get(addr);
                node.val = val;
            } else {
                // 不存在，说明是第一个节点
                addr_map.put(addr, new ListNode(val));
                head = addr_map.get(addr);
            }

            // 判断下一个节点，如果存在，我们就先放进去，之后再更新 val。使用 putIfAbsent 是考虑到环的情况，如果刚好是环，那么这一行不会执行
            if (next_addr != -1) {
                addr_map.putIfAbsent(next_addr, new ListNode(0));
                // 更新链表
                addr_map.get(addr).next = addr_map.get(next_addr);
            }
        }
        System.out.println(isExist(head) ? "true" : "false");
        scanner.close();
    }

    public static boolean isExist(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
