public class Huffman {
    static Queue tree = new Queue();

    public static void createQueue(String s) {
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

        //test print
//        for (int i = 0; i < tree.lastIndex; i++) {
//            System.out.println(tree.element[i].root.concat + " " + tree.element[i].root.count);
//        }
    }

//    static void huffmanCoding() {
//
//    }
}
