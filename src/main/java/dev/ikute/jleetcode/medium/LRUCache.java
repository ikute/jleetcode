package dev.ikute.jleetcode.medium;

import java.util.HashMap;

/**
 * LRU Cache problem.
 *
 * @see <a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a>
 */
public class LRUCache {

    private HashMap<Integer, LinkedList.Node> cache;
    private LinkedList list;
    private int capacity;

    public LRUCache(int capacity) {
        this.cache = HashMap.newHashMap(capacity);
        this.list = new LinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        LinkedList.Node node = cache.get(key);
        int value = node.value;

        list.remove(node);
        list.prepend(node);

        return value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            LinkedList.Node node = cache.get(key);
            list.remove(node);

            node.value = value;
            list.prepend(node);

            return;
        }

        if (cache.size() >= capacity) {
            cache.remove(list.tail.key);
            list.remove(list.tail);
        }

        LinkedList.Node node = new LinkedList.Node(key, value);
        list.prepend(node);
        cache.put(key, node);
    }

    static class LinkedList {

        Node head, tail;

        public LinkedList() {
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void prepend(Node node) {
            if (isEmpty()) {
                head = node;
                tail = node;

                return;
            }

            node.next = head;
            head.prev = node;
            head = node;
        }

        public void remove(Node node) {
            if (isEmpty()) {
                return;
            }

            if (node == head && node == tail) {
                head = null;
                tail = null;

                return;
            }

            if (node == head) {
                Node next = head.next;
                head.next = null;

                head = next;
                head.prev = null;
            } else if (node == tail) {
                Node prev = tail.prev;
                tail.prev = null;

                tail = prev;
                tail.next = null;
            } else {
                Node prev = node.prev;
                Node next = node.next;

                prev.next = next;
                next.prev = prev;

                node.prev = null;
                node.next = null;
            }
        }

        public static class Node {
            int key, value;
            Node next, prev;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
