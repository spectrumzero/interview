package linkedlist;

public class DemoReverseII {
    public static void main(String[] args) {

    }

    public static ListNode solutionOnetime(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        // 先找到 prev，进入区间前的一个节点
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        // 区间的第一个节点
        ListNode start = prev.next;
        // 从区间的第一个节点开始，遍历这个区间
        ListNode cur = start;
        // 再对这个区间进行头插，更新区间的 start。还有剩下 right - left 个节点要处理，每次处理一个 next 节点
        for (int i = 0; i < right - left; i++) {
            // 每次处理一个 next 节点
            ListNode next = cur.next;
            // 拔根而起
            cur.next = next.next;
            // 头插法：把脱离出来的节点，作为当前区间的第一个节点，所以要有以前 start 的维持
            next.next = start;
            // 头插法，肯定要更新头 start。但是 cur 不用更新
            start = next;
        }
        // 最后，把头接回去。start 符合定义
        prev.next = start;
        return dummy.next;
    }

    public static ListNode solution(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = findNode(dummy, left);
        ListNode start = prev.next;
        ListNode end = findNode(dummy, right).next;
        ListNode next = end.next;
        end.next = null;
        prev.next = reverse(start);
        start.next = next;
        return dummy.next;
    }

    public static ListNode findNode(ListNode head, int index) {
        for (int i = 1; i < index; i++) {
            head = head.next;
        }
        return head;
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
