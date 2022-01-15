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

    public Tree concatTree(Tree t1, Tree t2) {
        return new Tree(t1.root.concat + t2.root.concat, t1.root.count + t2.root.count);
    }
}
