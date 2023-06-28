package LinkedList;

class CircularLinkedList {
    CircularNode head;
    static class CircularNode{
        int data;
        CircularNode next;
        CircularNode(int d){ data =  d;}
    }


    public static void main(String[] args) {
        CircularNode n = new CircularNode(2);
        CircularNode n1 = new CircularNode(5);
        CircularNode n2 = new CircularNode(6);
        n.next = n1;
        n1.next = n2;
        n2.next = n;
        printList(n);

    }

    private static void printList(CircularNode n) {
        CircularNode temp = n;
        do
        {
            System.out.println("temp.data = " + temp.data);
            temp = temp.next;
        }while (temp != n);
    }
}
