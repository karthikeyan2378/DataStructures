package Tree;

import static Tree.BinaryTree.createSampleBinaryTree;

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
        BinaryTree tree = createSampleBinaryTree();
        System.out.println("getHeightOfTheTree(tree.root) = " + getHeightOfTheTree(tree.root));
    }

    public static int getHeightOfTheTree(Node root) {
        if(root == null)
            return 0;

        int leftHeight = getHeightOfTheTree(root.left);
        int rightHeight = getHeightOfTheTree(root.right);
         return  Math.max(leftHeight, rightHeight)+1;
    }
}
