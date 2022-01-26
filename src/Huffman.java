import java.util.HashMap;

public class Huffman {
    static String text;
    static Queue queue;
    static Tree huffmanTree;
    static HashMap<String, String> codes;

    private static void createQueue(String s) {
        text = s;
        queue = new Queue();
        codes = new HashMap<>();
        int[] count = new int[256];

        int len = s.length();

        for (int i = 0; i < len; i++) {
            count[s.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                String concat = "" + (char) i;
                queue.enqueue(new Tree(concat, count[i]));
            }
        }
    }
    private static void find_char_code(Node node, String c) {
        if (node == null)
            return;
        // string with 1 length means we are on leaf node
        if (node.character.length() == 1) {
            codes.put(node.character, c);
            return;
        }
        find_char_code(node.left, c + "0");
        find_char_code(node.right, c + "1");
    }

    static String encoding(String s) {
        // create a sorted queue of tree
        createQueue(s);
        while (queue.lastIndex > 1) {
            Tree p = queue.dequeue();
            Tree q = queue.dequeue();
            queue.enqueue(Tree.concatTree(p, q));
        }
        huffmanTree = queue.dequeue();

        //add each char and its special code in hashmap
        find_char_code(huffmanTree.root, "");

        String result = "";
        //add code char by char to result
        for (int i = 0; i < text.length(); i++) {
            result += codes.get(text.charAt(i) + "");
        }
        return result;
    }

}
