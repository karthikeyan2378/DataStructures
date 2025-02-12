package LinkedList;

public class ConvertArray2DoubleList {
    static class Node {
        int data;
        Node next;
        Node back;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }


    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        Node head = new Node(a[0]);
        Node prev =  head;

        for (int i = 1; i < a.length; i++) {

            Node temp = new Node(a[i]);
            prev.next = temp;
            prev = temp;

        }

        while(head != null)
        {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
