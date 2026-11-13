package exams;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class DemoShao {
    public static void main(String[] args) {

    }

    public static ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode prev = dummy;
        ListNode cur = pHead;
        // 链表已排序
        while (cur != null && cur.next != null) {
            // 判断有相同的，整个链条处理干净
            if (cur.val == cur.next.val) {
                while (cur != null && cur.next != null && cur.val == cur.next.val) {
                    // 把 cur 往后移动，直到到达分界处，cur 为 null 或者 cur 就是这个链条上的最后一个点
                    cur = cur.next;
                }
                if (cur == null || cur.next == null) {
                    prev.next = null;
                    break;
                } else {
                    prev.next = cur.next;
                    cur = cur.next;
                }
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return dummy.next;

    }


}
