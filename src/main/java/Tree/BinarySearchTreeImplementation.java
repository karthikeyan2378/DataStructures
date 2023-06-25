package Tree;

public class BinarySearchTreeImplementation {

    public static Node insertNode(Node root, int key)
    {
        if(root ==  null) {
            root = new Node(key);
            return root;
        }

        if(key<root.key)
            root = insertNode(root.left, key);
        else if(key>root.key)
            root = insertNode(root.right, key);

        return root;
    }
    public static void main(String[] args) {
        BinaryTree bst = new BinaryTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        bst.printPreOrder(bst.root);
    }
}
