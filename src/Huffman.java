import java.util.HashMap;

public class Huffman {
    static boolean isEncoding;
    static String text;
    static String encoded;
    static Queue queue;
    static Tree huffmanTree;
    static HashMap<String, String> codes;

    private static void createQueue(String s) {
        text = s;
        encoded = "";
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
            if (isEncoding)
                codes.put(node.character, c);
            else
                codes.put(c, node.character);
            return;
        }
        find_char_code(node.left, c + "0");
        find_char_code(node.right, c + "1");
    }

    static private void createTree() {
        while (queue.lastIndex > 1) {
            Tree p = queue.dequeue();
            Tree q = queue.dequeue();
            queue.enqueue(Tree.concatTree(p, q));
        }
        huffmanTree = queue.dequeue();
    }

    static String encoding(String s) {
        isEncoding = true;
        // create a sorted queue of tree
        createQueue(s);

        //create huffman tree
        createTree();

        //add each char and its special code in hashmap
        find_char_code(huffmanTree.root, "");

        //add code char by char to result
        for (int i = 0; i < text.length(); i++) {
            encoded += codes.get(text.charAt(i) + "");
        }
        return encoded;
    }

    static String decoding(Queue newQueue, String encodedText) {
        isEncoding = false;
        codes = new HashMap<>();
        queue = newQueue;
        createTree();
        find_char_code(huffmanTree.root, "");

        int pos = 0;
        String res = "";
        for (int i = 0; i <= encodedText.length(); i++) {
            String temp = encodedText.substring(pos, i);
            if (codes.containsKey(temp)) {
                res += codes.get(temp);
                pos = i;
            }
        }
        return res;
    }

}
