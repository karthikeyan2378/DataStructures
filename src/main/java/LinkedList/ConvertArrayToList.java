package LinkedList;

public class ConvertArrayToList {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};

        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            System.out.println(temp.data);
            mover.next = temp;
            mover = mover.next;
        }

        //Node a = head;
        while (head != null)
        {
            System.out.println(head.data);
            head= head.next;
        }
    }
}
