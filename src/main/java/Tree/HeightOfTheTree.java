package Tree;
/*
* height of the tree formula
*
* Math.max(leftHeight, rightHeight) + 1
*
* calculate the maximum of left and right sub tree and add 1 for current node
*
* o(n) for space and time complexity
*
* */
public class HeightOfTheTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root =  new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("getHeightOfTheTree(tree.root) = " + getHeightOfTheTree(tree.root));
    }

    private static int getHeightOfTheTree(Node root) {
        if(root == null)
            return 0;

        int leftHeight = getHeightOfTheTree(root.left);
        int rightHeight = getHeightOfTheTree(root.right);
         return  Math.max(leftHeight, rightHeight)+1;
    }
}
