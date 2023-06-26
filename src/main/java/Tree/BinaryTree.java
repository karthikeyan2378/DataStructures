package Tree;

public class BinaryTree {
    Node root;
    BinaryTree() {
        root = null;
    }

    /*
    * For InOrder traversal:
    *
    * left --- root --- right
    *
    * */
    public  void printInOrder(Node node)
    {
        if(node == null)
            return;

        printInOrder(node.left);

        System.out.print("  " + node.key + " ");

        printInOrder(node.right);

    }

    /*
     * For PreOrder traversal:
     *
     * root --- left --- right
     *
     * */
    public void printPreOrder(Node node) {
        if(node == null)
            return;

        System.out.println("node.key = " + node.key);

        System.out.print("  " + node.key + " ");

        printPreOrder(node.left);

        printPreOrder(node.right);
    }


    /*
     * For Postorder traversal:
     *
     * left --- right --- root
     *
     * */

    private void printPostOrder(Node node) {
        if(node == null)
            return;


        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print("  " + node.key + " ");




    }
    public void insert(int key)
    {
        System.out.println("key inside insert = " + key);
        root = BinarySearchTreeImplementation.insertNode(root, key);
    }

    public static  BinaryTree createSampleBinaryTree()
    {
        BinaryTree tree = new BinaryTree();
        tree.root =  new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        return tree;
    }
    public static void main(String[] args) {
        BinaryTree tree = createSampleBinaryTree();

        /*
        * BFS Traversal , inorder, preorder, postorder
        *
        * */

        System.out.println("InOrder Traversal");
        tree.printInOrder(tree.root);
        System.out.println();
        System.out.println("PreOrder Traversal");
        tree.printPreOrder(tree.root);

        System.out.println();
        System.out.println("PostOrder Traversal");
        tree.printPostOrder(tree.root);

    }




}
