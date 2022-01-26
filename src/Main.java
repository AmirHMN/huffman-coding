import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String result = init();
        System.out.println(result);
    }

    public static String init() {
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1:
                String text = input.nextLine();
                return Huffman.encoding(text);
            case 2:
                Queue queue = new Queue();
                int numbers = input.nextInt();

                for (int i = 0; i < numbers; i++) {
                    queue.enqueue(new Tree(input.next(), input.nextInt()));
                    input.nextLine();
                }
                String encoded = input.next();
                return Huffman.decoding(queue, encoded);
            default:
                break;
        }
        return "";
    }
}
