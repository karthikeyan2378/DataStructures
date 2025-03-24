package StackAndQueueStriver;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;
    Map<Integer,Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map.clear();
        head.next = tail;
        tail.prev = head;
    }

    public void deleteNode(Node node)
    {
        Node prevNode = node.prev;
        Node afterNode = node.next;
        prevNode.next = afterNode;
        afterNode.prev = prevNode;
    }

    public void insertAfterHead(Node node)
    {
        Node currAfterHead = head.next;
        head.next = node;
        node.next = currAfterHead;
        node.prev = head;
        currAfterHead.prev = node;
    }

    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        }
        else
        {
            if(map.size()== capacity)
            {
                Node node = tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }

            Node node = new Node(key, value);
            map.put(key, node);
            insertAfterHead(node);
        }

    }

    class Node{
        int key, value;
        Node prev,next;
        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */