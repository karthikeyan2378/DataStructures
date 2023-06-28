package Concepts.LinkedList;

import jdk.internal.org.objectweb.asm.util.CheckSignatureAdapter;

public class DoubleLinkedList {
    static class DoubleNode{
        DoubleNode prev, next;
        int data;
        DoubleNode(int val)
        {
            data = val;
            prev = null;
            next = null;
        }
    }

    public static void insertAtBegin(int data)
    {
        DoubleNode n = new DoubleNode(data);

    }
    public static void main(String[] args) {
        insertAtBegin(2);
    }
}
