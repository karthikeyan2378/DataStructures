package Concepts.LinkedList;

import com.sun.xml.internal.bind.v2.TODO;

class LinkedList
{
    Node head;  // head of list

    /* Node Class */
    class Node
    {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int d) {data = d; next = null; }
    }
    /*
    * INSERT AT THE BEGINING OF THE NODE*/

    public void pushAtFirst(int newNode)
    {
        Node currentNode = new Node(newNode);
        currentNode.next = head;
        head = currentNode;
    }

    /*INSERT IN THE MIDDLE*/
    public void pushAfterTheNode(Node prevNode, int data)
    {
        if(prevNode == null)
        {
            System.out.println("Previous Node is null");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;

    }

    /*Insert at last*/
    public  void pushAfterTheLast(int data)
    {

        Node newNode = new Node(data);
        System.out.println("head = " + head);
        if(head ==  null){
            head =  new Node(data);
            return;
        }

        System.out.println("sssssssss");
        newNode.next = null;

        Node last =  head;
        while (last.next!=null)
        {
            last = last.next;
        }

        last.next = newNode;

        return;
        
    }
    
    public static void printList(Node head)
    {
      int count =0;
        while (head != null)
        {
            System.out.print( + head.data + "  ");
            count++;
            head = head.next;
        }
        System.out.println("count = " + count);
    }

    public  boolean searchIterative(int x)
    {
        Node tNode = head;
        System.out.println("x = " + x);
        while (tNode != null)
        {
            if( tNode.data == x )
                return true;
            tNode = tNode.next;
        }
        return false;
    }

    public boolean searchRecursive(Node head, int x)
    {
        if(head == null)
            return false;

        if(head.data== x)
            return true;
        
        return searchRecursive(head.next, x);
    }

    public static void reverse(Node head)
    {
        System.out.println("head.data = " + head.data);
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        System.out.println("After reverse");
        printList(head);

    }

    public static void deleteAtBegin(Node head)
    {
        Node temp = head;
        head = temp.next;
        printList(head);
    }

    
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.pushAfterTheLast(10);
        System.out.println("PushedAttheLAST");
        llist.printList(llist.head);

        llist.pushAtFirst(5);
        llist.pushAtFirst(6);
        System.out.println("PushedAttheFirst");
        llist.printList(llist.head);
        llist.pushAfterTheNode(llist.head.next, 8);
        System.out.println("PushedAttheMIDDLE");
        llist.printList(llist.head);
        llist.searchIterative(6);
        System.out.println("findx = " + llist.searchIterative(6));
        System.out.println("findx1 = " + llist.searchRecursive(llist.head, 2));
       // reverse(llist.head);
        deleteAtBegin(llist.head);
    }
}