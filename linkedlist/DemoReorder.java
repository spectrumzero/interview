package linkedlist;

public class DemoReorder {
    public static void main(String[] args) {

    }

    public static void solution(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode tmp = mid.next;
        mid.next = null;
        ListNode l1 = head;
        ListNode l2 = reverse(tmp);
        merge(l1, l2);
    }

    public static void merge(ListNode l1, ListNode l2) {
        // 交替插入
        while (l2 != null) {
            // 连接用的临时变量
            ListNode tmp_l1 = l1.next;
            ListNode tmp_l2 = l2.next;
            // 把 l2 拼到 l1 上
            l1.next = l2;
            l2.next = tmp_l1;
            // 下一个要正确处理的位置
            l1 = tmp_l1;
            l2 = tmp_l2;
        }
    }

    // 其实 mid 你用 dummy 完全可以，就是不知道为什么 leetcode 的判题，用 dummy 不行。
    // 原则一样的，就是 fast 要比 slow 提前一格。也通用。
    public static ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
