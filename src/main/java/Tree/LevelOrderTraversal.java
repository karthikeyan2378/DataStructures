package Tree;

import static Tree.BinaryTree.createSampleBinaryTree;
import static Tree.HeightOfTheTree.getHeightOfTheTree;

public class LevelOrderTraversal {
    public  static  void printLevelOrder(Node root)
    {
        int height = getHeightOfTheTree(root);
        System.out.println("height = " + height);
        for (int i = 1; i <= height; i++) {
            printCurrentLevel(root, i);
        }
    }

    public static void printCurrentLevel(Node node, int level)
    {
        if(node == null)
            return;
        if(level ==1)
            System.out.print(" "+ node.key + " ");
        else if(level >1)
        {
            printCurrentLevel(node.left, level-1);
            printCurrentLevel(node.right, level-1);
        }

    }

    public static void main(String[] args) {
        BinaryTree tree = createSampleBinaryTree();
        printLevelOrder(tree.root);

    }
}
