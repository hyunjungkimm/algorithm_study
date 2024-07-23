package src.leetcode;

import java.util.*;

class Node {
    public int key;
    public int value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(2,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
    private int capacity = 0;
    private Set<Node> cache = new LinkedHashSet<>();
    private Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!keyToNode.containsKey(key)) {
            return -1;
        }

        Node node = keyToNode.get(key);
        cache.remove(node);
        cache.add(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(keyToNode.containsKey(key)) {
            keyToNode.get(key).value = value;
            get(key);
            return;
        }

        if(cache.size() == capacity) {
            Node lastNode = cache.iterator().next();
            cache.remove(lastNode);
            keyToNode.remove(lastNode.key);
        }

        Node node = new Node(key,value);
        cache.add(node);
        keyToNode.put(key,node);
    }
}