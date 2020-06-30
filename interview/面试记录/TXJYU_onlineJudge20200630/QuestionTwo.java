package com.example.test.questions;

import java.security.InvalidParameterException;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import javax.xml.soap.Node;

/**
 * @author yejingxuan
 */
public class QuestionTwo {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);

        soutLruCache(lruCache);
        lruCache.set(4, 4);
        System.out.println("======");
        soutLruCache(lruCache);
    }

    private static void soutLruCache(LRUCache lruCache) {
        lruCache.getCache().keySet().forEach(key -> {
            System.out.println(lruCache.getCache().get(key));
        });

    }


    static class LRUCache {

        private int capacity;

        private Map<Integer, ItemNode> cache;

        private ItemNode head = new ItemNode();

        private ItemNode tail = new ItemNode();


        LRUCache(int capacity) {
            if (capacity <= 0) {
                throw new InvalidParameterException("parameter should be larger than 0");
            }
            this.capacity = capacity;
            cache = new HashMap<Integer, ItemNode>(capacity);
            head.next = tail;
            head.prev = null;
            tail.prev = head;
            tail.next = null;
        }


        int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }

            ItemNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        }

        void set(int key, int value) {
            if (cache.containsKey(key)) {
                ItemNode node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                ItemNode newNode = new ItemNode();
                newNode.setValue(value);
                newNode.setKey(key);
                addFirst(newNode);
                cache.put(key, newNode);
                if (cache.size() > capacity) {
                    int toRemove = removeLast();
                    cache.remove(toRemove);
                }
            }
        }

        private int removeLast() {
            int key = tail.prev.key;
            removeNode(tail.prev);
            return key;
        }

        private void addFirst(ItemNode node) {
            node.prev = head;
            node.next = head.next;
            node.next.prev = node;
            node.prev.next = node;
        }

        private void moveToHead(ItemNode node) {
            removeNode(node);
            addFirst(node);
        }

        private void removeNode(ItemNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public Map<Integer, ItemNode> getCache() {
            return cache;
        }
    }


    static class ItemNode {

        private Integer value;

        private Integer key;

        ItemNode prev;

        ItemNode next;


        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public ItemNode getPrev() {
            return prev;
        }

        public void setPrev(ItemNode prev) {
            this.prev = prev;
        }

        public ItemNode getNext() {
            return next;
        }

        public void setNext(ItemNode next) {
            this.next = next;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "ItemNode{" +
                    "value=" + value +
                    ", key=" + key +
                    '}';
        }
    }

}
