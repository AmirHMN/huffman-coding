public class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree(String concat, int count) {
        this.root = new Node(concat, count);
    }

    public void addLeft(Node newNode) {
        root.left = newNode;
    }

    public void addRight(Node newNode) {
        root.right = newNode;
    }
}
