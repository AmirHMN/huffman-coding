public class Tree {
    Node root;
    public Tree() {

    }
    public Tree(Node root) {
        this.root = root;
    }

    public Tree(String concat, int count) {
        this.root = new Node(concat, count);
    }

    public void addLeft(Tree newTree) {
        root.left = newTree.root;
    }

    public void addRight(Tree newTree) {
        root.right = newTree.root;
    }

    public static Tree concatTree(Tree t1, Tree t2) {
        Tree res = new Tree(t1.root.character + t2.root.character, t1.root.count + t2.root.count);
        res.addLeft(t1);
        res.addRight(t2);
        return res;
    }

    @Override
    public String toString() {
     return "";
    }
}
