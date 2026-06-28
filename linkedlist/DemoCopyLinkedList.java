package linkedlist;

import java.util.*;

class RandomLinkedList {
    int val;
    RandomLinkedList random;
    RandomLinkedList next;
    public RandomLinkedList(int val) {
        this.val = val;
    }
}

public class DemoCopyLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        // 简单粗暴地处理输入
        RandomLinkedList[] nodes = new RandomLinkedList[len];
        int[] randomIndex = new int[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new RandomLinkedList(scanner.nextInt());
            randomIndex[i] = scanner.nextInt();
        }
        for (int i = 0; i < len - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        for (int i = 0; i < len; i++) {
            if (randomIndex[i] != -1) nodes[i].random = nodes[randomIndex[i]];
        }
        RandomLinkedList head = deepCopy(nodes[0]);
        RandomLinkedList cur = head;
        StringBuilder stringBuilder = new StringBuilder();
        // 简单粗暴地处理输出，链表还用到了
        List<RandomLinkedList> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            int index = -1;
            if (cur.random != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) == cur.random) {
                        index = i;
                        break;
                    }
                }
            }
            stringBuilder.append(cur.val).append(" ").append(index);
            if (cur.next != null) {
                stringBuilder.append("\n");
            }
            cur = cur.next;
        }
        System.out.print(stringBuilder);
        scanner.close();
    }

    public static RandomLinkedList deepCopy(RandomLinkedList head) {
        Map<RandomLinkedList, RandomLinkedList> map = new HashMap<>();
        // 先做出来，拷贝出来。映射的作用？
        RandomLinkedList cur = head;
        while (cur != null) {
            RandomLinkedList node = new RandomLinkedList(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            RandomLinkedList clone = map.get(cur);
            clone.next = map.get(cur.next);
            clone.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
