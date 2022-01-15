public class Huffman {
    static Queue tree = new Queue();

    private static void createQueue(String s) {
        int[] count = new int[256];

        int len = s.length();

        for (int i = 0; i < len; i++) {
            count[s.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                String concat = "" + (char) i;
                tree.enqueue(new Tree(concat, count[i]));
            }
        }
    }

    static Tree huffmanCoding(String s) {
        createQueue(s);
        while(tree.lastIndex>1){
            Tree p= tree.dequeue();
            Tree q= tree.dequeue();
            tree.enqueue(Tree.concatTree(p,q));
        }
        return tree.dequeue();
    }
}
