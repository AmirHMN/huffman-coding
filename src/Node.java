public class Node {
    String character;
    int count;
    Node left;
    Node right;

    public Node(String concat, int count) {
        this.character = concat;
        this.count = count;
        this.left = null;
        this.right = null;
    }
}
