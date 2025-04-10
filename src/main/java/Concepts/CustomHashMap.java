package Concepts;

import java.util.Objects;

public class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16; // Default size
    private static final double LOAD_FACTOR = 0.75; // Load factor for resizing

    private Node<K, V>[] buckets;
    public int size;

    // Node class to store key-value pairs
    static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next; // For handling collisions

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public CustomHashMap() {
        this.buckets = new Node[INITIAL_CAPACITY];
        this.size = 0;
    }

    // Hash function to get index
    private int getIndex(K key) {
        return (Objects.hashCode(key) & 0x7FFFFFFF) % buckets.length;
    }

    // Put method to insert/update key-value pairs
    public void put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> newNode = new Node<>(key, value);

        if (buckets[index] == null) {
            buckets[index] = newNode; // No collision
        } else {
            // Handle collision (Linked List Chaining)
            Node<K, V> current = buckets[index];
            Node<K, V> prev = null;
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value; // Update existing key
                    return;
                }
                prev = current;
                current = current.next;
            }
            prev.next = newNode; // Append to the list
        }
        size++;

        // Resize if load factor exceeds threshold
        if (size > LOAD_FACTOR * buckets.length) {
            resize();
        }
    }

    // Get method to retrieve value by key
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null; // Key not found
    }

    // Remove method to delete key-value pairs
    public void remove(K key) {
        int index = getIndex(key);
        Node<K, V> current = buckets[index];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = current.next; // Remove head node
                } else {
                    prev.next = current.next; // Bypass node
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Resize the HashMap when load factor exceeds threshold
    private void resize() {
        Node<K, V>[] oldBuckets = buckets;
        buckets = new Node[oldBuckets.length * 2]; // Double capacity
        size = 0;

        for (Node<K, V> head : oldBuckets) {
            while (head != null) {
                put(head.key, head.value); // Rehash elements
                head = head.next;
            }
        }
    }

    // Display method (for debugging)
    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("Bucket " + i + ": ");
            Node<K, V> current = buckets[i];
            while (current != null) {
                System.out.print("[" + current.key + " -> " + current.value + "] ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public int size() {
        return size;
    }
}
