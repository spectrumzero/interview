package linkedlist;

import javax.security.auth.login.AccountLockedException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class DemoLRU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine().trim());
        LRU lru = new LRU(size);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().trim().split("\\s+");
            if (line[0].equals("put")) {
                lru.put(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
            } else {
                System.out.println(lru.get(Integer.parseInt(line[1])));
            }
        }
        scanner.close();
    }
}

// 基本定义
class DListNode {
    int key;
    int val;
    DListNode prev;
    DListNode next;

    DListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

}

class LRU {
    int capacity;
    Map<Integer, DListNode> hashMap;
    DListNode dummyhead;
    DListNode dummytail;

    // 构造函数
    LRU(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>();
        dummyhead = new DListNode(-1, -1);
        dummytail = new DListNode(-1, -1);
        // 链接
        dummyhead.next = dummytail;
        dummytail.prev = dummyhead;
    }

    public int get(int key) {
        if (hashMap.get(key) != null) {
            DListNode node = hashMap.get(key);
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }


    public void put(int key, int value) {
        if (hashMap.get(key) != null) {
            DListNode node = hashMap.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if (hashMap.size() == capacity) {
                int keyToDelete = deleteNode();
                hashMap.remove(keyToDelete);
            }
            DListNode node = new DListNode(key, value);
            // 可千万别忘了这里
            hashMap.put(key, node);
            addToHead(node);
        }
    }

    public void moveToHead(DListNode node) {
        DListNode prev = node.prev;
        DListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        addToHead(node);
    }

    public void addToHead(DListNode node) {
        DListNode head = dummyhead.next;
        dummyhead.next = node;
        node.prev = dummyhead;
        node.next = head;
        head.prev = node;
    }

    public int deleteNode() {
        DListNode tail = dummytail.prev;
        DListNode tmp = tail.prev;
        tmp.next = dummytail;
        dummytail.prev = tmp;
        return tail.key;
    }

}
