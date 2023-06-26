package Tree;

 class Node {
    public int key;
    public Node left;
    public Node right;

    public Node(int value)
    {
        this.key = value;
        this.left = this.right = null;
    }
}

