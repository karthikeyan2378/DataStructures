package Tree;
/*
*
* ALGORITHM LOGIC
  1. Print the left boundary in top-down manner.

  2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
     2.1 Print all leaf nodes of left sub-tree from left to right.
     2.2 Print all leaf nodes of right subtree from left to right.
  3. Print the right boundary in bottom-up manner.
We need to take care of one thing that nodes are not printed again. e.g. The left most node is also the leaf node of the tree.
*
* */


public class BoundaryTraversal {
    /*Basic function to calculate boundary traversal*/
    public static void printBoundary(Node node)
    {
        if(node ==  null)
            return;

        System.out.print(node.key + " ");
        printLeftBoundary(node.left);

        printLeaves(node.left);
        printLeaves(node.right);

        printRightBoundary(node.right);


    }

    /*function to calculate right boundary from bottom to up*/
    private static void printRightBoundary(Node node) {

        if(node ==  null)
            return;

        if(node.right !=  null)
        {
            System.out.print(node.key+ " ");
            printLeftBoundary(node.right);
        }
        else if(node.left !=  null)
        {
            System.out.print(node.key+ " ");
            printLeftBoundary(node.left);
        }
    }

    /*function to calculate the leaf nodes from left to right*/
    private static void printLeaves(Node node) {
        if(node == null)
            return;

        printLeaves(node.left);
        if(node.left == null && node.right == null)
            System.out.print(node.key + " ");
        printLeaves(node.right);
    }

    /*function to calculate the left boundary from top to bottom*/
    private static void printLeftBoundary(Node node) {

        if(node ==  null)
            return;

        if(node.left !=  null)
        {
            System.out.print(node.key+ " ");
            printLeftBoundary(node.left);
        }
        else if(node.right !=  null)
        {
            System.out.print(node.key+ " ");
            printLeftBoundary(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        printBoundary(tree.root);
    }
}
